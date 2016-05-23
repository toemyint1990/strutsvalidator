package com.user.form;



import org.apache.struts.validator.ValidatorForm;

public class UserForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	String username;
	String pwd;
	String pwd2;
	
	String email;
	String usertype;
	String facility;
	String phone;
	
	
	public String getUsername(){
		return username;
	}
   public void setUsername(String username){
	    this.username=username;   
   }
   public String getPwd(){
	   return pwd;
   }
   public void setPwd(String pwd){
	   this.pwd=pwd;
   }
   public String getPwd2(){
	   return pwd2;
   }
   public void setPwd2(String pwd2){
	   this.pwd2=pwd2;
   }
   public String getEmail(){
	   return email;
   }
   public void setEmail(String email){
	   this.email=email;
   }
   public String getPhone(){
	   return phone;
   }
   public void setPhone(String phone ){
	   this.phone=phone;
   }
  
   public void setFacility(String facility ){
	   this.facility=facility;
   }
   public String getFacility(){
	   return facility;
   }
   public void setUsertype(String usertype){
	   this.usertype=usertype;
   }
   public String getUsertype(){
	   return usertype;
   }
   
   
 
   }
