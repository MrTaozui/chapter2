package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tjj .
 * CustomerService 单元测试
 */
public class CustomerServiceTest {
    private final CustomerService customerService;
    public CustomerServiceTest(){
        customerService=new CustomerService();
    }
    // JUnit 在调用每个@Test方法之前，都会调用 @Before方法
    @Before
    public void init() throws Exception{
    	//因为是就近读取 则Thread.currentThread.getClassLoder.As...读取的是测试数据库的配置
    	//所以操作的是测试数据库
       DatabaseHelper.excuteSqlFile("sql/customer_init.sql");
    }
    @Test
    public void getCustomerListTest()throws Exception{
        String keyWard="";
        List<Customer> customerList=customerService.getCustomerList(keyWard);
        for (Customer customer:customerList
             ) {
            System.out.println(customer);
        }
      //  Assert.assertEquals(2,customerList.size());
    }
    @Test
    public void getCustomerTest()throws Exception{
        long id=1;
        Customer customer=customerService.getCustomer(id);
        System.out.println(customer);
        Assert.assertNotNull(customer);
    }
    @Test
    public void createCustomerTest()throws Exception{
       /* Map<String,Object> fieldMap=new HashMap<String,Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","13512345678");
        boolean result=customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);*/
    }
    @Test
    public  void updateCustomerTest()throws Exception{
        long id=1;
        Map<String,Object> fieldMap=new HashMap<String,Object>();
        fieldMap.put("contact","Eric");
        boolean result=customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);

    }

    public void deleteCustpmerTest()throws  Exception{
        long id=9;
        boolean result=customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
    public static void main(String[] args) {
    	try {
			new CustomerServiceTest().deleteCustpmerTest();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
