package com.tatsam.priorityeng.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@Component
@Entity
@EntityScan("com.tatsam.priorityeng.model.*")
@Table(name = "user_info")
public class UserInfoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq")
	@SequenceGenerator(name = "user_info_seq", sequenceName = "user_info_seq", allocationSize = 1)
	@Column(name = "ID")
	int id;

	@Column(name="user_name")
    private String userName;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserInfoModel()
    {
        
    }
	public UserInfoModel(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserInfoModel [id=" + id + ", userName=" + userName + "]";
	}
    
}
