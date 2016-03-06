/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter.hibernate.dao.impl;

import com.crm.twitter.hibernate.dao.TwitterDao;
import com.crm.twitter.hibernate.entity.TwitterAccounts;
import com.crm.twitter.hibernate.entity.TwitterDirectMessages;
import com.crm.twitter.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juanmunoz
 */
@Repository
@Transactional
public class TwitterDaoImpl implements TwitterDao {

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public void saveAccount(TwitterAccounts twitterAccounts) {
        hibernateUtil.create(twitterAccounts);
    }

    @Override
    public void saveMessage(TwitterDirectMessages twitterDirectMessages) {
        hibernateUtil.create(twitterDirectMessages);
    }

    @Override
    public List<TwitterDirectMessages> getDirectMessages() {
        List<TwitterDirectMessages> messages = null;
        try {
            messages = hibernateUtil.fetchAll(TwitterDirectMessages.class);

//            for (TwitterDirectMessages messageObj : messages) {
//                System.out.println("The text is:  >>>>>>> " + messageObj.getMessage());
//            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<TwitterAccounts> getTwitterAccounts() {
        List<TwitterAccounts> accounts = null;

        System.out.println("The accounts xxxxxxx");

        try {
            accounts = hibernateUtil.fetchAll(TwitterAccounts.class);
            System.out.println("The accounts " + accounts.get(0).getClient());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return accounts;
    }

}
