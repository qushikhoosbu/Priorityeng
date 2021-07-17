package com.tatsam.priorityeng.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.tatsam.priorityeng.model.UserInfo;
import com.tatsam.priorityeng.model.UserInfoModel;
import com.tatsam.priorityeng.model.UserPriority;
import com.tatsam.priorityeng.model.UserPriorityModel;
import com.tatsam.priorityeng.repository.UserInfoRepo;
import com.tatsam.priorityeng.repository.UserPriorityRepo;
import com.tatsam.priorityeng.service.*;

//import com.monitorjbl.json.JsonView;
//import static com.monitorjbl.json.Match.match;

@RestController
public class UserInfoPriorityInfoController 
{	
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserPriorityService userPriorityService;
	
	@Autowired 
	private UserInfoRepo userInfoRepo;
	
	@Autowired 
	private UserPriorityRepo userPriorityRepo;
	
	
	
	//list of all the user with their info
	@GetMapping("/listuserInfo")
	 public List<UserInfoModel> getListUserInfo()
	{
		return userInfoService.findAllByOrderBy();
	}

	
	//the user with their info specifically for that given id
    @GetMapping("/userInfo")
	 public UserInfoModel getUserInfo(@RequestParam int id)
	{
		return userInfoService.findById(id);
	}
	
    
  //list of all the priorities for the given specified  user 
	@GetMapping("/listofPriority")
	 public List<UserPriorityModel> getListOfPriority(@RequestParam int id)
	{
			return userPriorityService.findById(id);
	}


	
	
	//list of all the priorities for the all the user enrolled
	@CrossOrigin(allowedHeaders = {"*"},methods ={RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.PATCH},origins = {"*"})
	  @GetMapping("/user/priority") 
		public ResponseEntity<ArrayList<UserInfo>> getAllUserInfo(@RequestParam(value="Id" , required = false) Integer Id) 
	{
	  ArrayList<UserInfo> app1 =new ArrayList<>();
	  
	  List< UserInfoModel> userInfoModelList=userInfoService.findAllByOrderBy();
	  
	  for( UserInfoModel userInfoModelObject : userInfoModelList) 
	  { 
		  UserInfo UserInfoObject =new UserInfo();
	  
		  UserInfoObject.setId(userInfoModelObject.getId());
		  UserInfoObject.setUserName(userInfoModelObject.getUserName());
		  List< UserPriorityModel> userPriorityList= userPriorityService.findById(userInfoModelObject.getId());
	  
		  ArrayList<UserPriority> UserPriorityObj =new ArrayList<>();
	  for( UserPriorityModel UserPriorityModelObject : userPriorityList) 
	  { 
		  UserPriority userPriorityObject = new UserPriority(); 
		  userPriorityObject.setPriorityId(UserPriorityModelObject.getId());
		  userPriorityObject.setPriorityName(UserPriorityModelObject.getPriorityName());
		  userPriorityObject.setPriorityRate(UserPriorityModelObject.getPriorityRate());
		  userPriorityObject.setPriorityState(UserPriorityModelObject.getPriorityState()); 
		  
		  UserPriorityObj.add(userPriorityObject);
	  }
	  
	  UserInfoObject.setUserPriority(UserPriorityObj);
	  app1.add(UserInfoObject);
	  }
	  
	  return new ResponseEntity<ArrayList<UserInfo>> (app1, HttpStatus.OK);
	  
	  }
	
	
	//delete any user info
	@DeleteMapping("/userinfo/{id}")
	public Map<String, Boolean> deleteUserInfo(@PathVariable(value = "id") int id)
	{
	 UserInfoModel userInfoModel = userInfoRepo.findById(id);
	 
	 userInfoRepo.delete(userInfoModel);
	 
	 Map<String, Boolean> response = new HashMap<>();
	 response.put("deleted", Boolean.TRUE);
	 
	 return response;
	}
	
	
	//create a new user info
	@RequestMapping(value = "/user",method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    @ResponseBody
	public ResponseEntity createUser(@RequestBody UserInfoModel userInfoModel) 
	{
		 userInfoRepo.save(userInfoModel);
		 System.out.println("done");
		 return new ResponseEntity("Created",HttpStatus.CREATED);
	}
	
	
	//update a new user info
	@PutMapping("/user/{id}")
	public ResponseEntity<UserInfoModel> updateEmployee(@PathVariable(value = "id") int id, @Valid @RequestBody UserInfoModel userInfoModelObj) 
	{
		UserInfoModel userInfoModel = userInfoRepo.findById(id);
	
		userInfoModel.setId(userInfoModelObj.getId());
		userInfoModel.setUserName(userInfoModelObj.getUserName());
	 
	 final UserInfoModel userInfoModell = userInfoRepo.save(userInfoModel);
	 
	 return ResponseEntity.ok(userInfoModell);
	}
	
	
	
	//delete any priority info
	@DeleteMapping("/priorityinfo/{id}")
	public Map<String, Boolean> deletePriorityInfo(@PathVariable(value = "id") int id)
	{
		UserPriorityModel userPriorityModel = userPriorityRepo.findByUserId(id);
	 
	 userPriorityRepo.delete(userPriorityModel);
	 
	 Map<String, Boolean> response = new HashMap<>();
	 response.put("deleted", Boolean.TRUE);
	 
	 return response;
	}
	
	
	
	//create a new priority info
	@RequestMapping(value = "/priorityinfo",method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    @ResponseBody
	public ResponseEntity createPriority(@RequestBody UserPriorityModel userPriorityModel) 
	{
		userPriorityRepo.save(userPriorityModel);
		 System.out.println("done");
		 return new ResponseEntity("Created",HttpStatus.CREATED);
	}
	
	
	
	//update any priority info
	@PutMapping("/priorityinfo/{id}")
	public ResponseEntity<UserPriorityModel> updatePriority(@PathVariable(value = "id") int id, @Valid @RequestBody UserPriorityModel userPriorityModelObj) 
	{
		UserPriorityModel userPriorityModel = userPriorityRepo.findByUserId(id);
	
		userPriorityModel.setId(userPriorityModelObj.getId());
		userPriorityModel.setPriorityName(userPriorityModelObj.getPriorityName());
		userPriorityModel.setPriorityRate(userPriorityModelObj.getPriorityRate());
		userPriorityModel.setPriorityState(userPriorityModelObj.getPriorityState());
		userPriorityModel.setUserMappingPriorityModel(userPriorityModelObj.getUserMappingPriorityModel());
	 
	 final UserPriorityModel userPriorityModell = userPriorityRepo.save(userPriorityModel);
	 
	 return ResponseEntity.ok(userPriorityModell);
	}
	
	 		     
}
