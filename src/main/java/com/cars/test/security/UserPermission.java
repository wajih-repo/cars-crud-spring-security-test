package com.cars.test.security;

public enum UserPermission {

	WRITE("admin:write");
	
	private final String permission;
	
	UserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	

	 
}
