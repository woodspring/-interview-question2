package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.service.NumberService;
import com.example.demo.service.impl.NumberServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


public class TestNumberService {
	private final static Logger logger = LoggerFactory.getLogger(TestNumberService.class);
	
	private NumberService numSrv = new NumberServiceImpl();
	
	@Test
	public void testStoreNumber() {
		int testId = numSrv.storeNumber("2,1,4,7,33,19,15");
		logger.info( "retI :{}", testId);
		assertEquals( "1", Integer.valueOf(testId).toString());
	}
	
	@Test
	public void testGetNumber() {
		String numStr1 = "2,1,4,7,33,19,15";
		String numStr2 = "98,3,6,100, 102987,7";
		int testId = numSrv.storeNumber(numStr1);
		testId = numSrv.storeNumber(numStr2);
		List<Integer> testIntList = numSrv.getNumber(1);
		StringBuffer strBuf = new StringBuffer();
		for (Integer item: testIntList) {
			strBuf.append(item.toString()+" ");
		}
		logger.info("org list:{}, result list:{}", numStr1, strBuf.toString());
		assertNotEquals( testIntList, numStr1);
		
		testIntList = numSrv.getNumber(2);
		strBuf = new StringBuffer();
		for (Integer item: testIntList) {
			strBuf.append(item.toString()+" ");
		}
		logger.info("org list:{}, result list:{}", numStr2, strBuf.toString());
		assertNotEquals( testIntList, numStr2);
		
	}

}
