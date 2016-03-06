/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter.hibernate.service.impl;

import com.crm.twitter.hibernate.dao.TwitterDao;
import com.crm.twitter.hibernate.entity.TwitterAccounts;
import com.crm.twitter.hibernate.entity.TwitterDirectMessages;
import com.crm.twitter.hibernate.service.TwitterHibernateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juanmunoz
 */
@Service
@Transactional
public class TwitterHibernateServiceImpl implements TwitterHibernateService {
    
    @Autowired
    private TwitterDao twitterDao;

    @Override
    public void saveAccount(TwitterAccounts twitterAccounts) {
        twitterDao.saveAccount(twitterAccounts);
    }

    @Override
    public void saveMessage(TwitterDirectMessages twitterDirectMessages) {
        twitterDao.saveMessage(twitterDirectMessages);
    }

    @Override
    public List<TwitterDirectMessages> getDirectMessages() {
        return twitterDao.getDirectMessages();
    }

    @Override
    public List<TwitterAccounts> getTwitterAccounts() {
        return twitterDao.getTwitterAccounts();
    }
    
}
