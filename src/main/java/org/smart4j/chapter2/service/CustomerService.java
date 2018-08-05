package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author tjj .
 */
public class CustomerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取用户列表
     * @param keyWord
     * @return
     */
    public  List<Customer> getCustomerList(String keyWord){     
            String sql="select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class,sql);
    
    }
    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
    	String sql="select * from customer where id =?";    	
        return  DatabaseHelper.queryEntity(Customer.class, sql, id);
    }
    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }
    /**
     * 更新用户
     */
    public  boolean updateCustomer(long id,Map<String,Object>fieldMap){       
        return  DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }
    /**
     * 删除用户
     */
    public boolean deleteCustomer(long id){
        return  DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
