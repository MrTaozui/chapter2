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
        Connection conn=DatabaseHelper.getConnection();
        try {
            String sql="select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class,sql);
        }
        finally {
            DatabaseHelper.closeConnection();
        }
    }
    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        //TODO
        return  null;
    }
    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        //TODO
        return false;
    }
    /**
     * 更新用户
     */
    public  boolean updateCustomer(long id,Map<String,Object>fieldMap){
        //TODO
        return  false;
    }
    /**
     * 删除用户
     */
    public boolean deleteCustpmer(long id){
    //TODO
        return  false;
    }
}
