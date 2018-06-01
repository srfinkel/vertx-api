package com.srfinkel.jobsapi;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class JobsData {

	  private static final AtomicInteger COUNTER = new AtomicInteger();
	  
	  private final int id;
	  private String title;
	  private String keyword;
	  private Date date;
	  private String rate;
	  private String country;
	  private String language;
	  
	  boolean fulltime;
	  boolean parttime;
	  
	  public JobsData(String title, String keyword) {
		  this.id = COUNTER.getAndIncrement();
		  this.title = title;
		  this.keyword = keyword;
		  this.date = date;
		  this.fulltime = false;
		  this.parttime = false;	  
	  }
}
