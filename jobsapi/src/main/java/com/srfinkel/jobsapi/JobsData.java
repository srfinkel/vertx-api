package com.srfinkel.jobsapi;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class JobsData {

	  private static final AtomicInteger COUNTER = new AtomicInteger();
	  
	  private final int id;
	  private String title;
	  private String keyword;
	  private Date date;
	  private int rate;
	  private String level;
	  private String country;
	  private String language;
	  
	  boolean fulltime;
	  boolean parttime;
	  boolean hourly;
	  
	  public JobsData(String title, String keyword, Date date, int rate, String level, String country, String language) {
		  this.id = COUNTER.getAndIncrement();
		  this.title = title;
		  this.keyword = keyword;
		  this.date = date;
		  this.rate = rate;
		  this.level = level;
		  this.country = country;
		  this.language = language;
		  this.fulltime = false;
		  this.parttime = false;
		  this.hourly = false;
	  }
	  
	  public JobsData() {
		  this.id = COUNTER.getAndIncrement();
	  }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public boolean isParttime() {
		return parttime;
	}

	public void setParttime(boolean parttime) {
		this.parttime = parttime;
	}

	public boolean isHourly() {
		return hourly;
	}

	public void setHourly(boolean hourly) {
		this.hourly = hourly;
	}

	public int getId() {
		return id;
	}
}
