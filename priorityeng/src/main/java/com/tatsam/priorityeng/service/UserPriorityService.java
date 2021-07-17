package com.tatsam.priorityeng.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.priorityeng.model.UserPriority;
import com.tatsam.priorityeng.model.UserPriorityModel;
import com.tatsam.priorityeng.repository.UserPriorityRepo;

@Service
public class UserPriorityService {
												 
	@Autowired 
	private UserPriorityRepo userPriorityRepo;
	
    public List <UserPriorityModel> findById(int id) {
		List <UserPriorityModel> userPriorityList = null;
		try {
			userPriorityList= userPriorityRepo.findById(id);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return userPriorityList;

	}
	    
}
