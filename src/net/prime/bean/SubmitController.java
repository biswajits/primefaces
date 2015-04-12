package net.prime.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class SubmitController implements Serializable{
	public String userInput;
	public String getUserInput() {
		return userInput;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
	public void submit(){
		System.out.println("submit called ");
		System.out.println("Input : "+userInput);
	}
	
	

}
