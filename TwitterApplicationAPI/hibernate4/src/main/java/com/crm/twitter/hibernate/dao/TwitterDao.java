/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter.hibernate.dao;

import com.crm.twitter.hibernate.entity.TwitterAccounts;
import com.crm.twitter.hibernate.entity.TwitterDirectMessages;
import java.util.List;

/**
 *
 * @author juanmunoz
 */
public interface TwitterDao {
    
    public void saveAccount(TwitterAccounts twitterAccounts);
    
    public void saveMessage(TwitterDirectMessages twitterDirectMessages);
    
    public List<TwitterDirectMessages> getDirectMessages();
    
    public List<TwitterAccounts> getTwitterAccounts();
    
}
