package com.tatsam.priorityeng.model;

public class UserPriority {
    private int priorityId;
    private String priorityName;
    private int priorityState;
    private int priorityRate;
    public int getPriorityId() {
        return priorityId;
    }
    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
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

    public UserPriority()
    {
        
    }

    public UserPriority(int priorityId, String priorityName, int priorityState, int priorityRate) {
        this.priorityId = priorityId;
        this.priorityName = priorityName;
        this.priorityState = priorityState;
        this.priorityRate = priorityRate;
    }
    @Override
    public String toString() {
        return "UserPriority [priorityId=" + priorityId + ", priorityName=" + priorityName + ", priorityRate="
                + priorityRate + ", priorityState=" + priorityState + "]";
    }

}
