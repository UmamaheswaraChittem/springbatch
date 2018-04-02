package com.springbatch.steps;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String>{

	public String process(String message) throws Exception {
		return message.toUpperCase();
	}

}
