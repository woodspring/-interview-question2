package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.NumberService;

@RestController
@RequestMapping("")
public class NumberController {
	private final static Logger logger = LoggerFactory.getLogger(NumberController.class);
	
	//@Autowired
	//@Qualifier("NumberService")
	//private NumberService numberSrv;
	
	@Autowired
	@Qualifier("NumberH2Service")
	private NumberService numberH2Srv;
	
//	@GetMapping("store")
//	public String storeNumbers(@RequestParam("numbers") String numbers) {
//		int retI = numberSrv.storeNumber(numbers);
//		String retStr = Integer.valueOf( retI).toString();
//		logger.info("storeNumbers, numbers:{}, index:{}", numbers, retStr);
//		return retStr;
//		
//	}
//	
//	@GetMapping("permutation")
//	public List<Integer> getNumber(@RequestParam("id") int id) {
//		List<Integer> resList = numberSrv.getNumber(id);
//		logger.info("numIndex:{}, resList:{}", id, resList);
//		return resList;
//	}

	
	@GetMapping("store")
	public String storeNumbersH2(@RequestParam("numbers") String numbers) {
		int retI = numberH2Srv.storeNumber(numbers);
		String retStr = Integer.valueOf( retI).toString();
		logger.info("storeNumbersH2, numbers:{}, index:{}", numbers, retStr);
		return retStr;
		
	}
	
	@GetMapping("permutation")
	public List<Integer> getNumber(@RequestParam("id") int id) {
		List<Integer> resList = numberH2Srv.getNumber(id);
		logger.info("getNumberH2: numIndex:{}, resList:{}", id, resList);
		return resList;
	}
}
