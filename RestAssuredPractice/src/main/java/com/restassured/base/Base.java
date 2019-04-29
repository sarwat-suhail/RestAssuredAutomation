package com.restassured.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.restassured.commonfiles.ReusableMethods;

public class Base {

	com.restassured.commonfiles.ReusableMethods rm;
	public Properties prop;
		@BeforeTest
		public void init() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\Files\\env.properties");	
			
		prop.load(fis);
		
		 rm=new com.restassured.commonfiles.ReusableMethods();
			rm.setProp(prop);
			
		
		
		
		}
		
		
	
		
		
		
	}
	
	
