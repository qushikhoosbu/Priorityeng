package com.tatsam.priorityeng.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@Component
@Entity
@EntityScan("com.tatsam.priorityeng.model.UserInfo")
@Table(name = "user_mapping_priority")
public class UserMappingPriorityModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_mapping_priority_seq")
	@SequenceGenerator(name = "user_mapping_priority_seq", sequenceName = "user_mapping_priority_seq", allocationSize = 1)
	@Column(name = "ID")
	long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id", nullable=false)
	@JsonIgnore
	@JsonIgnoreProperties(value = {"user_mapping_priority", "hibernateLazyInitializer"})
    private UserInfoModel userInfoModel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_priority_id", nullable=false)
	@JsonIgnore
	@JsonIgnoreProperties(value = {"user_mapping_priority", "hibernateLazyInitializer"})
    private UserPriorityModel userPriorityModel;
	
	
	/*
	 * @OneToMany(mappedBy="mUserMappingPriorityModel",fetch = FetchType.LAZY,
	 * cascade = CascadeType.ALL)
	 * 
	 * @JsonIgnore
	 * 
	 * @JsonIgnoreProperties(value = {"user_mapping_priority",
	 * "hibernateLazyInitializer"}) private List<UserPriorityModel>
	 * userPriorityModell;
	 */
	public UserMappingPriorityModel()
    {
        
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserInfoModel getUserInfoModel() {
		return userInfoModel;
	}
	public void setUserInfoModel(UserInfoModel userInfoModel) {
		this.userInfoModel = userInfoModel;
	}
	public UserPriorityModel getUserPriorityModel() {
		return userPriorityModel;
	}
	public void setUserPriorityModel(UserPriorityModel userPriorityModel) {
		this.userPriorityModel = userPriorityModel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserMappingPriorityModel(long id, UserInfoModel userInfoModel, UserPriorityModel userPriorityModel) {
		super();
		this.id = id;
		this.userInfoModel = userInfoModel;
		this.userPriorityModel = userPriorityModel;
	}
	
}
