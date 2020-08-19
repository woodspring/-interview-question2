package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.service.NumberService;


@Service
@Qualifier("NumberService")
public class NumberServiceImpl implements NumberService {
	private final static Logger logger = LoggerFactory.getLogger( NumberServiceImpl.class); 
	private ConcurrentSkipListMap<Integer, String> numberMap = new ConcurrentSkipListMap<>();
	private int size = 0; 
	@Override
	public int storeNumber(String numberStr) {
		size++;
		numberMap.put( Integer.valueOf( size),  numberStr);
		logger.info("numberStr:{} id:{}", numberStr, size);
		return size;
	}

	@Override
	public List<Integer> getNumber(int numId) {
		List<Integer> retList = new ArrayList<Integer>();
		if (numId > size) {
			logger.error(" getNumber numId:{} out of boundary..{}", numId, size);
			return retList;
		}
		String numStr = numberMap.get( Integer.valueOf(numId));
		logger.info(":numStr:{}", numStr);
		String[] strArray = numStr.split(",");
		ArrayList<String> strList = new ArrayList<>( Arrays.asList( strArray));
		int  listSize = strList.size();
		logger.info(":numStr:{} listSize:{}", numStr, listSize);
		while( listSize > 1) {
			int index = (int)(Math.random() * listSize);
			retList.add( Integer.valueOf(strList.get( index).trim()));
			logger.info("getNumber: listSize:{}, index:{}, item:{} retList:{}", listSize, index, strList.get(index), retList);
			strList.remove( index);
			listSize--;
		}
		logger.info("end random loop, listSize:{}, item:{}", listSize, strList.get(0));
		retList.add( Integer.valueOf(strList.get(0).trim()));
		
		return retList;
	}

}
