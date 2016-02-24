/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter.managers;

import com.crm.twitter.TestTwitterAPI;
import com.crm.twittermodel.dao.TwitterDAO;
import com.crm.twittermodel.entity.TwitterAccounts;
import com.crm.twittermodel.entity.TwitterDirectMessages;
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
public class TwitterAPIManager {

    private final ConfigurationBuilder configBuilder;
    private final TwitterFactory twitterFactory;
    private final TwitterDAO twitterDAO;

    public TwitterAPIManager(TwitterAccounts accounts) {

        configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true);
        configBuilder.setOAuthConsumerKey(accounts.getConsumerKey());
        configBuilder.setOAuthConsumerSecret(accounts.getConsumerSecret());
        configBuilder.setOAuthAccessToken(accounts.getAccessToken());
        configBuilder.setOAuthAccessTokenSecret(accounts.getAccessTokenSecret());

        twitterFactory = new TwitterFactory(configBuilder.build());
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("spring-context.xml");

        twitterDAO = (TwitterDAO) context.getBean("twitterDAO");

    }
    
    
    public void postDirectMessage(String screenName, String text) {
        Twitter sender = twitterFactory.getInstance();
        screenName = "@" + screenName;
        try {
            DirectMessage directMessage = sender.sendDirectMessage(screenName, text);
            System.out.println("Sent: " + directMessage.getText() 
                    + " to @" + directMessage.getRecipientScreenName());
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterAPIManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<DirectMessage> getTwitterDirectMessages() {
        Twitter twitter = twitterFactory.getInstance();
        List<DirectMessage> statusses = null;
        Paging pag = new Paging(1, 100);
        try {
            statusses = twitter.getDirectMessages(pag);
        } catch (TwitterException ex) {
            Logger.getLogger(
                    TestTwitterAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statusses;
    }

    public void saveMessages(List<DirectMessage> messages) {

        for (DirectMessage message : messages) {

            TwitterDirectMessages directMessage = new TwitterDirectMessages();
            directMessage.setClient("test");
            directMessage.setMessage(message.getText());
            directMessage.setSenderStringName(message.getSenderScreenName());
            directMessage.setRecipientScreenName(message.getRecipientScreenName());
            System.out.println(message.getSender().getName());
            twitterDAO.saveDirectMessage(directMessage);
            
        }

    }

}
