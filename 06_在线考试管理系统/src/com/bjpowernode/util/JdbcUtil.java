package com.bjpowernode.util;


import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

// JdbcUtil obj = new JdbcUtil();  obj.getCon()
// JdbcUtil obj = new JdbcUtil();  obj.createStatement();
// JdbcUtil.getCon();
public class JdbcUtil {
    /**
     * 在JDBC规范中 Connection创建与销毁最浪费时间
     */
     final String URL="jdbc:mysql://localhost:3306/bjpowernode?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
     final String USERNAME="root";
     final String PASSWORD="root";
     PreparedStatement ps= null;
     Connection con = null;

    //将jar包中driver实现类加载到JVM中
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //封装连接通道创建细节
    public  Connection   getCon(){

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 重载增快运行速度 使用ServletContext
     * @param request
     */
    public  Connection   getCon(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            boolean isTrue=(boolean)map.get(it.next());
            if(isTrue){
                con=(Connection) it.next();
                map.put(con,false);
                break;
            }
        }
        return con;
    }


    //封装交通工具创建细节
    public  PreparedStatement createStatement(String sql){

        try {
            ps =  getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 重载增快运行速度 使用ServletContext
     * @param request
     */
    public  PreparedStatement createStatement(String sql,HttpServletRequest request){
        try {
            ps=getCon(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }


    // ps与con销毁细节 insert,update,delete
    public  void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 重载增快运行速度 使用ServletContext
     * @param request
     */
    public  void close(HttpServletRequest request){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Connection用完先别销毁 先归还到Map集合 等到全局作用对象被销毁时 在进行close()
         */
        ServletContext application = request.getServletContext();
        Map map =(Map) application.getAttribute("key1");
        map.put(con,true);

    }

     //select ps,con,rs
    public  void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
