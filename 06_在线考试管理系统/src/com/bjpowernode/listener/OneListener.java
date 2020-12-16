package com.bjpowernode.listener;

import com.bjpowernode.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
     @Override
     public void contextInitialized(ServletContextEvent sce) {
          //在Tomcat启动时，预先创建20个Connection,在userDao.add方法执行时
          // 将实现创建好connection交给add方法
          JdbcUtil util=new JdbcUtil();
          Map map=new HashMap();
          int num=1;
          for (int i = 0; i <20 ; i++) {
               Connection conn=util.getCon();
               System.out.println("在Http服务器启动时，创建20个Connection "+conn);
               map.put(conn,true);
          }
          sce.getServletContext().setAttribute("key1",map);
     }

     @Override
     public void contextDestroyed(ServletContextEvent sce) {
          ServletContext application = sce.getServletContext();
          Map map = (Map)application.getAttribute("key1");
          Iterator iterator = map.keySet().iterator();
          while (iterator.hasNext()){
               Connection conn=(Connection) iterator.next();
               if(conn!=null){
                    System.out.println("20个Connection "+conn+" 被销毁");
                    try {
                         conn.close();
                    } catch (SQLException throwables) {
                         throwables.printStackTrace();
                    }

               }
          }
     }
}
