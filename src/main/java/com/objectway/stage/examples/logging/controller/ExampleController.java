package com.objectway.stage.examples.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ExampleController {
	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
	private final Random random = new Random();

	@GetMapping("/example")
	public String example() {
		logger.trace("Trace message");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");

		return "example";
	}

	@GetMapping("/roll")
	public void roll() {
		for (int i = 0; i < 1000; i++) {
			final int dice = 1 + random.nextInt(6);
			logger.info("Dice side: {}", dice);
		}
	}
}
