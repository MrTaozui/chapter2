package org.smart4j.chapter2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.io.IOException;
import java.util.List;

/**
 * @author tjj .
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet{
	private CustomerService customerService;
	
	@Override
	public void init() throws ServletException {
		customerService=new CustomerService();//可以避免创建多个 CustomerService实例
		//其实整个Web应用只需要一个customerService实例
	}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Customer>   customerList=	customerService.getCustomerList("");
    req.setAttribute("customerList", customerList);
    req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);//转发
      
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
