/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitter.crm.api;

import com.crm.twitter.managers.TwitterAPIManager;
import com.crm.twittermodel.entity.TwitterDirectMessages;
import com.crm.twittermodel.managers.TwitterManager;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author juanmunoz
 */
@Path("/twitter")
public class TwitterService {
    
    private UriInfo context;
    private final TwitterManager manager;
    private final TwitterAPIManager twitterApiManager;
    
    public TwitterService() {
        manager = new TwitterManager();
        twitterApiManager = new TwitterAPIManager(manager.getTwitterAccounts().get(0));
    }

    @GET
    @Path("/message")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TwitterDirectMessages> setMessage(
            @DefaultValue("Hiya") @QueryParam("message") String message){
        List<TwitterDirectMessages> messages = manager.getMessages();
        return messages;        
    }
    
    @POST
    @Path("/post/directmessage")
    @Produces(MediaType.APPLICATION_JSON)
    public String postDirectMessage(@FormParam("screenName") String screenName,
            @FormParam("text") String text) {
        twitterApiManager.postDirectMessage(screenName, text);
        
        return "true";
    }
    
}
