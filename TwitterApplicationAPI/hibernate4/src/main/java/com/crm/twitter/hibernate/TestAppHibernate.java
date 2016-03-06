/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter.hibernate;

import com.crm.twitter.hibernate.dao.TwitterDao;
import com.crm.twitter.hibernate.service.TwitterHibernateService;
import com.ranga.AppTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author juanmunoz
 */
@Component
public class TestAppHibernate {
    
//    @Autowired
//    private TwitterDao twitterDao;
    
//    public TwitterDao getTwitterDao() {
//        return twitterDao;
//    }
    
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
//        TestAppHibernate standalone = ctx.getBean(TestAppHibernate.class);
//        
//        standalone.getTwitterDao().getTwitterAccounts();
//        
//        standalone.getTwitterDao().getDirectMessages();
        
        TwitterHibernateService service = ctx.getBean(TwitterHibernateService.class);
        service.getDirectMessages();
        
        
    }
    
}
