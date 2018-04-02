package com.springbatch.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jobcompletionlistener.JobCompletionListener;
import com.springbatch.steps.Processor;
import com.springbatch.steps.Reader;
import com.springbatch.steps.Writer;

@Configuration
public class BatchConfig {
	
	  @Autowired
	  public JobBuilderFactory jobBuilderFactory;

	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;
	
	  @Bean
	  public Step takeStep() {
		  return  stepBuilderFactory.get("takestep1").<String, String>chunk(1)
				  .reader(new Reader()).processor(new Processor())
				  .writer(new Writer()).build();
	  }
	  
	  @Bean Job processJob() {
		  return jobBuilderFactory.get("processjob")
				  .incrementer(new RunIdIncrementer())
				  .listener(listener())
				  .flow(takeStep()).end().build();
		  
	  }

	private JobExecutionListener listener() {
		// TODO Auto-generated method stub
		
		return new JobCompletionListener();
		
	}
	  
	  	

}
