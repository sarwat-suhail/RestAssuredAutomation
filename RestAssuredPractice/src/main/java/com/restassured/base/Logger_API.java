package com.restassured.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

public class Logger_API {
public org.apache.logging.log4j.Logger log;
	@Test
	public void logger() {
		
 log=LogManager.getLogger(Logger_API.class.getName());
 log.error("i am in error");
 log.fatal("this is fatal");
 log.debug("this is debug");
 log.trace(" i am printing trace message ");
	}
	
	
	
	
	
}
