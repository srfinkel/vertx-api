package com.srfinkel.jobsapi;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.core.json.Json;

public class JobsAPIVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobsAPIVerticle.class);

	private Map<Integer, JobsData> jobs = new LinkedHashMap<>();

	private Date date;
	
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new JobsAPIVerticle());
	}

	@Override
	public void start(Future<Void> fut) {
		LOGGER.info("Verticle JobsAPIVerticle Started");
		
		createSomeJobs();

		Router router = Router.router(vertx);

		router.route("/").handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.putHeader("content-type", "text/html").end("<h1>Rest with Vertx</h1>");
		});
		
		router.route("/assests/*").handler(StaticHandler.create("assets"));
		
		router.get("/api/v1/jobs").handler(this::getAll);
		router.route("/api/v1/jobs*").handler(BodyHandler.create());
		router.get("/api/v1/jobs/:id").handler(this::getOne);

		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080),
				result -> {
					if (result.succeeded()) {
						fut.complete();
					} else {
						fut.fail(result.cause());
					}
				});
	}
	
	private void getOne(RoutingContext routingContext) {
		  final String id = routingContext.request().getParam("id");
		  if(id == null) {
			  routingContext.response().setStatusCode(400).end();
		  } else {
			  final Integer idAsInteger = Integer.valueOf(id);
			  JobsData job = jobs.get(idAsInteger);
			  if (job == null) {
				  routingContext.response().setStatusCode(404).end();
			  } else {
				  routingContext.response()
				  .putHeader("content-type", "application/json; charset=utf-8")
				  .end(Json.encodePrettily(job));
			  }
		  }
		}
	
	private void getAll(RoutingContext routingContext) {
		  routingContext.response()
		      .putHeader("content-type", "application/json; charset=utf-8")
		      .end(Json.encodePrettily(jobs.values()));
		}
	
	private void createSomeJobs() {
		JobsData magician = new JobsData("Magician Wanted", "magic, bunny, hat", date, 20, "experienced", "USA", "English", false, true, false);
		jobs.put(magician.getId(), magician);
		JobsData sorcerer = new JobsData("Hiring Sorcerer", "broom, wand", date, 25, "mid-level", "Australia", "English", true, false, false);
		jobs.put(sorcerer.getId(), sorcerer);
	}
}
