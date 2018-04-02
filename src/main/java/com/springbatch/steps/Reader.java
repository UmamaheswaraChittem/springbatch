package com.springbatch.steps;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {
	
	private String[] messages= {
								"Spring Batch", 
								"First Program", 
								"We are using H2 database"
								};
	private int count = 0; 
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		
		if(count < messages.length) {
			return messages[count++];
		}else {
			count = 0;
		}
		
		return null;
	}

}
