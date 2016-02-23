/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel.managers;

import com.crm.twittermodel.entity.TwitterAccounts;
import com.crm.twittermodel.entity.TwitterDirectMessages;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author juanmunoz
 */
public class TwitterManager {

    private SessionFactory sessionFactory;
    private AnnotationConfiguration config;

    public TwitterManager() {

        try {
            System.out.println("Starting hibernate session factory..... ");
            config = new AnnotationConfiguration();
            sessionFactory = config.configure().buildSessionFactory();
            System.out.println("Ending Hibernate Session factory ....");
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    } 

    public void createClient(TwitterAccounts twitterAccount) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            
            session.save(twitterAccount);
            
            tx.commit();
            
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void saveDirectMessage(TwitterDirectMessages directMessage) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            
            session.save(directMessage);
            
            tx.commit();
            
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public List<TwitterDirectMessages> getMessages() {
        Session session = null;
        List<TwitterDirectMessages> messages = null;
        try{
            session = sessionFactory.openSession();
            messages = session.createQuery("FROM TwitterDirectMessages").list();
            
            for (TwitterDirectMessages messageObj : messages) {
                System.out.println("The text is:  >>>>>>> " + messageObj.getMessage());
            }
            
        }catch(HibernateException ex) {
            ex.printPartialStackTrace(null);
        }
        return messages;
    }
    
    public List<TwitterAccounts> getTwitterAccounts() {
        
        List<TwitterAccounts> accounts = null;
        
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            List<TwitterAccounts> results = session.createQuery("FROM TwitterAccounts").list();
            accounts = results;
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
        return accounts;
        
    }

}
