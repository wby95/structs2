package com.wby.action;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.wby.dao.CustomerLoginDao;
import com.wby.dao.RegisterDao;
import com.wby.entity.Customer;


public class LoginAction {
	private String userName;
	private String password;
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoginAction(){
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//默认方法
	public String execute()throws Exception{
		if(userName!=null && password!=null){
			if(CustomerLoginDao.validateLogin(userName, password)){
				//保存当前的登录用户
				Map session=ActionContext.getContext().getSession();
				session.put("loginUser", getUserName());
				return "success";
			}else{
				return "input";
			}
		}else{
			return "input";
		}
	}

	public String register(){

		if(RegisterDao.registerUser(customer)){
			return "input";
		}
		else
			return "input";

	}


}
