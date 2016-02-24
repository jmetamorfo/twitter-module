/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel.dao;

import com.crm.twittermodel.entity.TwitterAccounts;
import com.crm.twittermodel.entity.TwitterDirectMessages;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author juanmunoz
 */
public class TwitterDAO {
    private HibernateTemplate template;
    
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void saveAccount(TwitterAccounts account) {
        template.save(account);
    }  
    
    public void saveDirectMessage(TwitterDirectMessages twitterDirectMessage) {
        template.save(twitterDirectMessage);
    }
    
    public List<TwitterAccounts> getTwitterAccounts() {
        
        List<TwitterAccounts> accounts = null;
        
        System.out.println("The accounts xxxxxxx");
        
        try {
            accounts = template.find("FROM TwitterAccounts");
            System.out.println("The accounts " + accounts.get(0).getClient());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return accounts;
    }
}
