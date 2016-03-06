/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitter.web.client.listener;

import com.crm.twitter.hibernate.TestAppHibernate;
import com.crm.twitter.hibernate.entity.TwitterAccounts;
import com.crm.twitter.hibernate.service.TwitterHibernateService;
import com.crm.twittermodel.quartz.AccountThread;
import com.ranga.AppTest;
import com.ranga.dao.EmployeeDAO;
import com.ranga.entity.Employee;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author juanmunoz
 */
public class MyServletContextListener implements ServletContextListener {
    
    private AccountThread accountThread;
    private Thread thread = null;
//    private TwitterDAO twitterDAO;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("ServletContextListener started");
        
//        ApplicationContext context = 
//                new ClassPathXmlApplicationContext("spring-context.xml");
//
//        twitterDAO = (TwitterDAO) context.getBean("twitterDAO");
//        
//        List<TwitterAccounts> accounts = twitterDAO.getTwitterAccounts();
//        
//        System.out.println("------------- Come on -------- " + accounts);
//        
//        for (TwitterAccounts account : accounts) {
//            System.out.println("++++++++++++++++ The account in servlet listener: ++++++++ " 
//                    + account.getName());
//        }
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        
        TwitterHibernateService service = ctx.getBean(TwitterHibernateService.class);
        
        
        List<TwitterAccounts> accounts = service.getTwitterAccounts();
        
        accountThread = new AccountThread(1000);
        
        for (TwitterAccounts account : accounts) {
            accountThread.setInterval(7000);
            thread = new Thread(accountThread);
            thread.setName(account.getClient());
            thread.start();
        }
        
        

//        for (int x = 0; x <= 2; x++) {
//            accountThread.setInterval(7000);
//            thread = new Thread(accountThread);
//            thread.start();
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("ServletContextListener destroyed");	
        
        if (thread != null) {
            try {
                accountThread.terminate();
                //thread.join();
                System.out.println("Thread successfully stopped.");
            } catch (Exception ex) {
                Logger.getLogger(MyServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
