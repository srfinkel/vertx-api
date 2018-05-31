package com.srfinkel.jobsapi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class JobsAPIVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobsAPIVerticle.class);

	public static void main( String[] args ) {
		Vertx vertx = Vertx.vertx();

	}
	
	@Override
    public void start() {
    	LOGGER.info("Verticle JobsAPIVerticle Started");
	
	}
    	
	@Override
	public void stop() {
		LOGGER.info("Verticle JobsAPIVerticle Stopped");
	}

}
