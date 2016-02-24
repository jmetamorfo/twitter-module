/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel;

import com.crm.twittermodel.entity.TwitterAccounts;
import com.crm.twittermodel.managers.TwitterManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author juanmunoz
 */
public class TestHibernateApp {
    
    private static SessionFactory factory;
    
    public static void main(String[] args) {
        
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            
            TwitterAccounts twitterAccount = new TwitterAccounts();
            
            twitterAccount.setClient("3142165072");
            twitterAccount.setIdString("3142165072");
            twitterAccount.setScreenName("CRMSuite_dev");
            twitterAccount.setProfileImage("http://pbs.twimg.com/profile_images/593144764553388033/wpb5bh1V_normal.png");
            twitterAccount.setName("CRMSuite");
            twitterAccount.setConsumerKey("XVZtAmerFp9AFgfCdo4G1UxEI");
            twitterAccount.setConsumerSecret("qEGgPyAXpdJihklGC6cGdESNDlgxnSbBAASxc6aVrfwW1gHgvs");
            twitterAccount.setAccessToken("3142165072-9B8cOBnr3HUu5Mu7JXgsM0P8FRefuC7zhDPr3uw");
            twitterAccount.setAccessTokenSecret("ZVkNJFvQTz1Y3iuphKopHA6CrFz84liBRzPYpbGfJrE6Z");
            twitterAccount.setIsActive(true);
            twitterAccount.setIsDeleted(false);
            twitterAccount.setIsValid(true);
            
            TwitterManager manager = new TwitterManager();
            //manager.createClient(twitterAccount);
            
            
            List<TwitterAccounts> twitterAccounts = manager.getTwitterAccounts();
            
            for (TwitterAccounts accounts : twitterAccounts) {
                System.out.println("Account name: " + accounts.getName());
            }
            
            manager.getMessages();
            
//            TwitterAPIManager test = new TwitterAPIManager(twitterAccounts.get(0));
//            test.getTwitterDirectMessages();
            
            //System.out.println(twitterAccounts.get(0).getAccessTokenSecret());
            
            //session.save(twitterAccount);
            
            
            /*List objects = session.createQuery("From TwitterAccounts").list();
            
            List<TwitterAccounts> listOfAccounts = (List<TwitterAccounts>)  objects;
            
            
            for (TwitterAccounts accounts : listOfAccounts) {
                System.out.println(accounts.getClient());
            }
            
            tx.commit();*/
            
        } catch(Throwable ex) {
            ex.printStackTrace();
        } 
        
        
    }
    
}
