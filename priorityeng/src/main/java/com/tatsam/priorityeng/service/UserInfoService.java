package com.tatsam.priorityeng.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsam.priorityeng.model.UserInfo;
//import com.tatsam.priorityeng.model.UserInfo;
import com.tatsam.priorityeng.model.UserInfoModel;
import com.tatsam.priorityeng.repository.UserInfoRepo;

@Service
public class UserInfoService {
												 
	@Autowired 
	private UserInfoRepo userInfoRepo;
	
	public List <UserInfoModel> findAllByOrderBy() {
		List <UserInfoModel> userInfoModelList = null;
		try {
			userInfoModelList= userInfoRepo.findAllByOrderBy();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return userInfoModelList;
	}

    public UserInfoModel findById(int id) {
		UserInfoModel userInfoModel = null;
		try {
			userInfoModel= userInfoRepo.findById(id);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return userInfoModel;

	}

	public void delete(UserInfoModel userInfoModel) {
		
	}
	        
}
