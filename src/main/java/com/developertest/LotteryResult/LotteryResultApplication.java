package com.developertest.LotteryResult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LotteryResultApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LotteryResultApplication.class, args);

		// Retrieve the JayodaLotteryResultsReader bean from the context
		JayodaLotteryResultsReader resultsFetcher = context.getBean(JayodaLotteryResultsReader.class);

		// Call the fetchAndSaveResults method to fetch and save the lottery results
		resultsFetcher.fetchAndSaveResults();

		// Close the context
		context.close();
	}
}
