/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel;

import com.crm.twittermodel.dao.TwitterDAO;
import com.crm.twittermodel.entity.TwitterAccounts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author juanmunoz
 */
public class TestHibernateSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        TwitterDAO twitterDAO = (TwitterDAO) context.getBean("twitterDAO");

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

        //twitterDAO.saveAccount(twitterAccount);
        
        twitterDAO.getTwitterAccounts();
    }

}
