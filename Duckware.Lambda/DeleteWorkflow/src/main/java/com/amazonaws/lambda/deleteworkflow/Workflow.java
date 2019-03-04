package com.amazonaws.lambda.deleteworkflow;

public class Workflow {
	private String username;
    private String password;
    private String workflowIndex;
    
	public String getUsername() {
        return username;
    }
	
	public void setUsername(String username) {
        this.username=username;
    }
	
	public String getPassword() {
        return password;
    }
	
	public void setPassword(String password) {
        this.password=password;
    }
	
	public String getWorkflowIndex() {
        return workflowIndex;
    }
	
	public void setWorkflowIndex(String workflowIndex) {
        this.workflowIndex=workflowIndex;
    }
	
    public Workflow(String username, String password, String workflowIndex) {
        this.username = username;
        this.password = password;
        this.workflowIndex = workflowIndex;
    }
    
    public Workflow() {
    	
    }
	
}
