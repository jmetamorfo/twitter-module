/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.twittermodel.quartz;

/**
 *
 * @author juanmunoz
 */
public class ChangingStateOfThread {

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        
        System.out.println(name);
        
        if ("1".equals(Thread.currentThread().getName())) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
        }
    }

}
