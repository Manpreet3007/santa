package com.chekk.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GiftCalculatorService implements GiftCalculator {

	public List<Integer> getMinGiftsForHood(int hoodCapacity, int []giftWeights){
		
		List<Integer> gifts = new ArrayList<Integer>();
		gifts = minGifts(giftWeights, giftWeights.length, hoodCapacity);
		return gifts;
	}
	

	List<Integer> minGifts(int giftWeights[], int m, int capacity)
    {
        // used to store minGifts for every value till capacity
        int minGifts[][] = new int[2][capacity + 1];
 
        List<Integer> gifts = new ArrayList<Integer>();
       
        for (int i = 1; i <= capacity; i++)
        	minGifts[0][i] = Integer.MAX_VALUE;
 
       
        for (int i = 1; i <= capacity; i++)
        {
            
            for (int j = 0; j < m; j++)
            if (giftWeights[j] <= i)
            {
                int subRes = minGifts[0][i - giftWeights[j]];
                if (subRes != Integer.MAX_VALUE
                       && subRes + 1 < minGifts[0][i]) {
                       minGifts[0][i] = subRes + 1;
                       minGifts[1][i] = i - giftWeights[j];
                }
                 
            }
             
        }
        
        int i = capacity;
        while(i > 0) {
        	gifts.add(i - minGifts[1][i]);
        	i = minGifts[1][i];	
        }
        
       Collections.sort(gifts, Collections.reverseOrder());
        return gifts;
         
    }
		
}
