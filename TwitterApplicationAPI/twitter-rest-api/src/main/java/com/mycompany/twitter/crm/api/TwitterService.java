/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitter.crm.api;

import com.crm.twittermodel.entity.TwitterDirectMessages;
import com.crm.twittermodel.managers.TwitterManager;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
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
    
    public TwitterService() {
    }

    @GET
    @Path("/message")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TwitterDirectMessages> setMessage(
            @DefaultValue("Hiya") @QueryParam("message") String message){
        TwitterManager manager = new TwitterManager();
        List<TwitterDirectMessages> messages = manager.getMessages();
        return messages;        
    }
    
}
