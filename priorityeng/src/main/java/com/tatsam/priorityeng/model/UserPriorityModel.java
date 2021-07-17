package com.tatsam.priorityeng.model;
import javax.persistence.CascadeType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@Component
@Entity
@EntityScan("com.tatsam.priorityeng.model.*")
@Table(name = "user_priority")
public class UserPriorityModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_priority_seq")
	@SequenceGenerator(name = "user_priority_seq", sequenceName = "user_priority_seq", allocationSize = 1)
	@Column(name = "ID")
	int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_mapping_priority_id")
	@JsonIgnore
	@JsonIgnoreProperties(value = {"user_priority", "hibernateLazyInitializer"})
    private UserMappingPriorityModel  userMappingPriorityModel;

	@Column(name="priority_name")
    private String priorityName;

    @Column(name="priority_state")
    private int priorityState;

    @Column(name="priority_Rate")
    private int priorityRate;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserMappingPriorityModel getUserMappingPriorityModel() {
		return userMappingPriorityModel;
	}
	public void setUserMappingPriorityModel(UserMappingPriorityModel userMappingPriorityModel) {
		this.userMappingPriorityModel = userMappingPriorityModel;
	}
	public String getPriorityName() {
		return priorityName;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	public int getPriorityState() {
		return priorityState;
	}
	public void setPriorityState(int priorityState) {
		this.priorityState = priorityState;
	}
	public int getPriorityRate() {
		return priorityRate;
	}
	public void setPriorityRate(int priorityRate) {
		this.priorityRate = priorityRate;
	}
	public UserPriorityModel()
	{
		
	}
	public UserPriorityModel(int id, UserMappingPriorityModel userMappingPriorityModel, String priorityName,
			int priorityState, int priorityRate) {
		super();
		this.id = id;
		this.userMappingPriorityModel = userMappingPriorityModel;
		this.priorityName = priorityName;
		this.priorityState = priorityState;
		this.priorityRate = priorityRate;
	}
	@Override
	public String toString() {
		return "UserPriorityModel [id=" + id + ", userMappingPriorityModel=" + userMappingPriorityModel
				+ ", priorityName=" + priorityName + ", priorityState=" + priorityState + ", priorityRate="
				+ priorityRate + "]";
	}
}
