package com.example.RegisterUser.Dto;

import java.util.Date;

public class EmployeeDTO {


    private int employeeid;
    private String username;
    private String address;
    private int mobile;
    private String password;
    private Date createdAt;
    
   

    public EmployeeDTO(int employeeid, String employeename, String address, int mobile,String password,Date createdAt) {
        this.employeeid = employeeid;
        this.username = employeename;
        this.address = address;
        this.mobile = mobile;
        this.password = password;
        this.createdAt = createdAt;
    }

    public EmployeeDTO() {
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

   
   public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeid=" + employeeid +
                ", employeename='" + username + '\'' +
                ", address='" + address + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}