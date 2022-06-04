package com.chekk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chekk.model.GiftCalculatorModel;
import com.chekk.service.GiftCalculator;

@RestController
public class GiftCalculatorController {

	@Autowired
	GiftCalculator giftService;

	@PostMapping("/hoodfiller")
	List<Integer> getMinGiftsForHood(@RequestBody GiftCalculatorModel giftCalc){
		
		return giftService.getMinGiftsForHood(giftCalc.getHood_capacity(), giftCalc.getPresent_weights());

	}
	
	
	
	
	
}
