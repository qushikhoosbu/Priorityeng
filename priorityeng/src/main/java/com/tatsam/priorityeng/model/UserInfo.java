package com.tatsam.priorityeng.model;

import java.util.List;

public class UserInfo {

    private int id;
    private String userName;
    private List<UserPriority> userPriority;
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
    public List<UserPriority> getUserPriority() {
        return userPriority;
    }
    public void setUserPriority(List<UserPriority> userPriority) {
        this.userPriority = userPriority;
    }

    public UserInfo()
    {
        
    }
    public UserInfo(int id, String userName, List<UserPriority> userPriority) {
        this.id = id;
        this.userName = userName;
        this.userPriority = userPriority;
    }
    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", userName=" + userName + ", userPriority=" + userPriority + "]";
    }
    
    
}
