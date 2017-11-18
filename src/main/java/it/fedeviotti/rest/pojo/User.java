package it.fedeviotti.rest.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "username", "accessToken", "creationTime", "numOfNotificationsPushed" })
public class User {
	
	private String username;
	private String accessToken;
	private Date creationTime;
	private int numOfNotificationsPushed;
	
	public User() {
		super();
	}
	
	public User(String username, String accessToken, Date creationTime, int numOfNotificationsPushed) {
		//super();
		this.username = username;
		this.accessToken = accessToken;
		this.creationTime = creationTime;
		this.numOfNotificationsPushed = numOfNotificationsPushed;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public int getNumOfNotificationsPushed() {
		return numOfNotificationsPushed;
	}
	public void setNumOfNotificationsPushed(int numOfNotificationsPushed) {
		this.numOfNotificationsPushed = numOfNotificationsPushed;
	}
	
	

}
