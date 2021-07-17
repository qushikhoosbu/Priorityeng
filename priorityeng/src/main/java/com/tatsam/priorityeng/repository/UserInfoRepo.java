package com.tatsam.priorityeng.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tatsam.priorityeng.model.UserInfo;
import com.tatsam.priorityeng.model.UserInfoModel;
//import com.tatsam.priorityeng.model.UserInfo;


@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoModel,Long> {

	@Query(value = "SELECT DISTINCT u.id,u.user_name FROM user_info u order by id", nativeQuery = true)
	List<UserInfoModel> findAllByOrderBy();
	
	@Query(value = "SELECT u.id,u.user_name FROM user_info u where u.id=:Id", nativeQuery = true)
	UserInfoModel findById(@Param("Id") int id);
	
}
