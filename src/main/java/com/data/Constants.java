package com.data;

public class Constants {
	public static final Constants BROWSER = new Constants("BROWSER");
	public static final Constants ENVIRONMENT = new Constants("ENVIRONMENT");
	public static final Constants DATA_FILE = new Constants("DATA_FILE");
	
	
	private String name;
	
	public Constants(String name) {
		this.name=name;
	}

	public String toString() {
		return name;
	}
	
	
	
}
