/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twitter.managers;

import com.crm.twitter.TestTwitterAPI;
import com.crm.twittermodel.entity.TwitterAccounts;
import com.crm.twittermodel.entity.TwitterDirectMessages;
import com.crm.twittermodel.managers.TwitterManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private ConfigurationBuilder configBuilder;
    private TwitterFactory twitterFactory;
    
    
    public TwitterAPIManager(TwitterAccounts accounts) {
        
        configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true);
        configBuilder.setOAuthConsumerKey(accounts.getConsumerKey());
        configBuilder.setOAuthConsumerSecret(accounts.getConsumerSecret());
        configBuilder.setOAuthAccessToken(accounts.getAccessToken());
        configBuilder.setOAuthAccessTokenSecret(accounts.getAccessTokenSecret());
        
        twitterFactory = new TwitterFactory(configBuilder.build());
        
        
    }
    
    
    public List<DirectMessage> getTwitterDirectMessages() {
        Twitter twitter = twitterFactory.getInstance();
        List<DirectMessage> statusses = null;
        try {
            Paging pag = new Paging(1, 100);
            statusses = twitter.getDirectMessages(pag);
            int count = 0;

            TwitterManager manager = new TwitterManager();
            
            for (DirectMessage message : statusses) {
                
                TwitterDirectMessages directMessage = new TwitterDirectMessages();
                directMessage.setClient("test");
                directMessage.setMessage(message.getText());
                directMessage.setSenderStringName(message.getSenderScreenName());
                directMessage.setRecipientScreenName(message.getRecipientScreenName());
                
                System.out.println("Begin " + count++);
                System.out.println(message.getSender().getName());
                System.out.println("End");
                
                manager.saveDirectMessage(directMessage);
            }
            
        } catch (TwitterException ex) {
            Logger.getLogger(TestTwitterAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return statusses;
    }
    
    
}
