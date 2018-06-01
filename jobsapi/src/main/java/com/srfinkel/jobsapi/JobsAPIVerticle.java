package com.srfinkel.jobsapi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class JobsAPIVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobsAPIVerticle.class);

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new JobsAPIVerticle());
	}
	
	@Override
	public void start(Future<Void> fut) {
		LOGGER.info("Verticle JobsAPIVerticle Started");

		vertx.createHttpServer().requestHandler(r -> {
			r.response().end("<h1>Hello Updated this Verticle</h1>");
		}).listen(config().getInteger("http.port", 8080), result -> {
			if (result.succeeded()) {
				fut.complete();
			} else {
				fut.fail(result.cause());
			}
		});
	}
}
