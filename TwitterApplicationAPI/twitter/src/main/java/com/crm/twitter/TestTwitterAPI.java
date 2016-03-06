/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter;

import com.crm.twitter.hibernate.entity.TwitterAccounts;
import com.crm.twitter.hibernate.service.TwitterHibernateService;
import com.crm.twitter.managers.TwitterAPIManager;
//import com.crm.twittermodel.dao.TwitterDAO;
//import com.crm.twittermodel.entity.TwitterAccounts;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author juanmunoz
 */
public class TestTwitterAPI {
    
    
    public void readMessages(TwitterAccounts accounts) {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(accounts.getConsumerKey());
        cb.setOAuthConsumerSecret(accounts.getConsumerSecret());
        cb.setOAuthAccessToken(accounts.getAccessToken());
        cb.setOAuthAccessTokenSecret(accounts.getAccessTokenSecret());
        
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();        
        
        try {
            Paging pag = new Paging(1, 100);
            List<DirectMessage> statusses = twitter.getDirectMessages(pag);
            int count = 0;
            for (DirectMessage message : statusses) {
                System.out.println("Begin " + count++);
                System.out.println(message.getSender().getName());
                System.out.println("End");

            }
            
        } catch (TwitterException ex) {
            Logger.getLogger(
                    TestTwitterAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("XVZtAmerFp9AFgfCdo4G1UxEI");
        cb.setOAuthConsumerSecret("qEGgPyAXpdJihklGC6cGdESNDlgxnSbBAASxc6aVrfwW1gHgvs");
        cb.setOAuthAccessToken("3142165072-9B8cOBnr3HUu5Mu7JXgsM0P8FRefuC7zhDPr3uw");
        cb.setOAuthAccessTokenSecret("ZVkNJFvQTz1Y3iuphKopHA6CrFz84liBRzPYpbGfJrE6Z");
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        
//        try {
//            String screenName = twitter.getAccountSettings().getScreenName();
//            
//            System.out.println(screenName);
//        } catch (TwitterException ex) {
//            Logger.getLogger(TestTwitterAPI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        try {
//            Paging pag = new Paging(1, 100);
//            List<Status> statusses = twitter.getHomeTimeline(pag);
//            int count = 0;
//            for (Status status : statusses) {
//                System.out.println("Begin " + count++);
//                System.out.println(status.getUser().getScreenName() + " : " + status.getText());
//                System.out.println("End");
//
//            }
//            
//        } catch (TwitterException ex) {
//            Logger.getLogger(TestTwitterAPI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        
        try {
            Paging pag = new Paging(1, 100);
            List<DirectMessage> statusses = twitter.getDirectMessages(pag);
            int count = 0;
            for (DirectMessage message : statusses) {
                System.out.println("Begin " + count++);
                System.out.println(message.getSender().getName());
                System.out.println("End");

            }
            
        } catch (TwitterException ex) {
            Logger.getLogger(TestTwitterAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        TwitterDAO twitterDAO = (TwitterDAO) context.getBean("twitterDAO");
        TwitterHibernateService service = context.getBean(TwitterHibernateService.class);
        
//        List<TwitterAccounts> accounts = twitterDAO.getTwitterAccounts();
        List<TwitterAccounts> accounts = service.getTwitterAccounts();
        
        TwitterAPIManager manager = new TwitterAPIManager(accounts.get(0));
        
//        manager.getTwitterDirectMessages();
        
        manager.saveMessages(manager.getTwitterDirectMessages());
        
//        manager.postDirectMessage("juanmuu", "Test from Java");
        
        /*Class myObjectClass = TwitterFactory.class;
        
        String className = myObjectClass.getName();
        
        System.out.println("Reflexion .....");
        
        System.out.println("The name of the class: " + className);
        
        int modifiers = myObjectClass.getModifiers();
        
        System.out.println("Modifiers: " + modifiers);
        
        String superClass = myObjectClass.getSuperclass().getName() ;
        
        System.out.println("Super class: " + superClass);
        
        Constructor[] constructors = myObjectClass.getConstructors();
        
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }
        
        Field[] fields = myObjectClass.getFields();
        
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
        }
        
        Method[] methods = myObjectClass.getMethods();
        
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
        }*/
        
        
        
    }
}
