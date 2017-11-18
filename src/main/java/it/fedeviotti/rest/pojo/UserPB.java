package it.fedeviotti.rest.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserPB {
	
	private boolean active;
	private String iden;
	private Double created;
	private Double modified;
	private String email;
	private String email_normalized;
	private String name;
	private String image_url;
	private int max_upload_size;
	
	public UserPB() {
		super();
	}
	
	public UserPB(boolean active, String iden, Double created, Double modified, String email, String email_normalized,
			String name, String image_url, int max_upload_size) {
		super();
		this.active = active;
		this.iden = iden;
		this.created = created;
		this.modified = modified;
		this.email = email;
		this.email_normalized = email_normalized;
		this.name = name;
		this.image_url = image_url;
		this.max_upload_size = max_upload_size;
	}



	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public Double getCreated() {
		return created;
	}
	public void setCreated(Double created) {
		this.created = created;
	}
	public Double getModified() {
		return modified;
	}
	public void setModified(Double modified) {
		this.modified = modified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_normalized() {
		return email_normalized;
	}
	public void setEmail_normalized(String email_normalized) {
		this.email_normalized = email_normalized;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getMax_upload_size() {
		return max_upload_size;
	}
	public void setMax_upload_size(int max_upload_size) {
		this.max_upload_size = max_upload_size;
	}
	

}
