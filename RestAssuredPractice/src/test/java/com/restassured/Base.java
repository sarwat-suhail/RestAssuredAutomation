package com.restassured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class Base {

	com.restassured.ReusableMethods rm;
	public Properties prop;
		@BeforeTest
		public void init() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\Files\\env.properties");	
			
		prop.load(fis);
		
		 rm=new com.restassured.ReusableMethods();
			rm.setProp(prop);
			
		
		
		
		}
		
		
	
		
		
		
	}
	
	
