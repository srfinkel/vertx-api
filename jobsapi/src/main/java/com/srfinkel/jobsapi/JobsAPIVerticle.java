package com.srfinkel.jobsapi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.Future;

public class JobsAPIVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobsAPIVerticle.class);

	public static void main( String[] args ) {
		
		Vertx vertx = Vertx.vertx();
		
		vertx.deployVerticle(new JobsAPIVerticle());

	}
	
	@Override
    public void start(Future<Void> fut) {
    	LOGGER.info("Verticle JobsAPIVerticle Started");
    	
//    	vertx.createHttpServer().requestHandler(request -> {
//    		request.response().end("<h1>Jobs Working</h1>");	
//    		}).listen(8080);
	
	}
    	
	@Override
	public void stop() {
		LOGGER.info("Verticle JobsAPIVerticle Stopped");
	}

}
