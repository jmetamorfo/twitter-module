/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author juanmunoz
 */
public class RunMeJob extends QuartzJobBean {
    
    private RunMeTask runMeTask;
    
    public void setRunMeTask(RunMeTask runMeTask) {
        this.runMeTask = runMeTask;
    }

    //@Override
    protected void executeInternal(JobExecutionContext jec) 
            throws JobExecutionException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        runMeTask.printMe();
    }
    
}
