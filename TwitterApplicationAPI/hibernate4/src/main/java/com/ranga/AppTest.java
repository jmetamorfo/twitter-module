/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ranga;

import com.ranga.dao.EmployeeDAO;
import com.ranga.dao.impl.EmployeeDAOImpl;
import com.ranga.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author juanmunoz
 */
@Component
public class AppTest {

    @Autowired
    private EmployeeDAO employeeDAO;
    
    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public static void main(String[] args) {
        
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        AppTest standalone = ctx.getBean(AppTest.class);
        
        Employee employee = new Employee();
        
        employee.setAge(22);
        employee.setName("juan");
        employee.setSalary(120000);
        
        standalone.getEmployeeDAO().createEmployee(employee);
    }

}
