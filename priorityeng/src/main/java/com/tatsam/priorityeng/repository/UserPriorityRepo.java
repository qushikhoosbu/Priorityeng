package com.tatsam.priorityeng.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestParam;

//import com.tatsam.priorityeng.model.UserPriorityModel;
import com.tatsam.priorityeng.model.UserPriority;
import com.tatsam.priorityeng.model.UserPriorityModel;

@Repository
public interface UserPriorityRepo extends JpaRepository<UserPriorityModel,Long> {
	
    @Query(value = "SELECT p.id ,p.user_mapping_priority_id, p.priority_name , p.priority_state , p.priority_Rate"
    		+ " FROM user_priority  p INNER JOIN user_mapping_priority ump on ump.user_priority_id=p.id"
    		+ " INNER JOIN user_info u on u.id=ump.user_info_id where u.id=:Id", nativeQuery = true)
	List<UserPriorityModel> findById(@Param("Id") int id);
    
    @Query(value = "SELECT p.id ,p.user_mapping_priority_id, p.priority_name , p.priority_state , p.priority_Rate"
    		+ " FROM user_priority  p INNER JOIN user_mapping_priority ump on ump.user_priority_id=p.id"
    		+ " INNER JOIN user_info u on u.id=ump.user_info_id where u.id=:Id", nativeQuery = true)
	UserPriorityModel findByUserId(@Param("Id") int id);

}
