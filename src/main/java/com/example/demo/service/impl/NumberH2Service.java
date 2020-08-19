package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.NumberRepo;
import com.example.demo.entity.NumberBase;
import com.example.demo.service.NumberService;

@Service
@Qualifier("NumberH2Service")
public class NumberH2Service implements NumberService {
	private static final Logger logger = LoggerFactory.getLogger(NumberH2Service.class);

	@Autowired
	private NumberRepo numberRepo;

	private int size = -99;
	
	@Override
	public int storeNumber(String numberStr) {
		if (size == -99) 
			size = getCount();
		size++;
		NumberBase entity = new NumberBase();
		entity.setNumberStr( numberStr);
		numberRepo.save( entity);
		logger.info("numberStr:{} id:{}", numberStr, size);
		return size;

	}

	@Override
	public List<Integer> getNumber(int numId) {
		if (size == -99) 
			size = getCount();
		List<Integer> retList = new ArrayList<Integer>();
		if (numId > size) {
			logger.error(" getNumber numId:{} out of boundary..{}", numId, size);
			return retList;
		}
		Optional<NumberBase> entity = numberRepo.findById( Long.valueOf(numId).longValue());
		if ( entity.isEmpty()) {
			logger.warn(" getNumber numId:{} NOT FOUND ..{}", numId, size);
			return retList;
		}
		String numStr = entity.get().getNumberStr();  
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
	
	private int getCount() {
		int retInt =0;
		long lCount = numberRepo.count();
		retInt = (lCount != 0) ? Long.valueOf( lCount).intValue() : 0;
		return retInt;
	}
	

}
