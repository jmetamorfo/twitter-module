/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel.quartz;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanmunoz
 */
public class AccountThread implements Runnable {
    
    private int interval;
    
    private volatile boolean running = true;

    public void terminate() {
        running = false;
    }
    
    public AccountThread(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
    
    @Override
    public void run() {
        
        while(running) {
            try {
                Thread.sleep(getInterval());
                System.out.println("My Thread Account with name: " 
                + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(AccountThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
