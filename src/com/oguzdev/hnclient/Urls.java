package com.oguzdev.hnclient;

public class Urls 
{
	// Hardcoded URLs of news.ycombinator.com
	public static String homePage = "http://news.ycombinator.com/";
	public static String trendingPage = "http://news.ycombinator.com/news";
	public static String morePage = "http://news.ycombinator.com/x?fnid=";
	public static String newPage = "http://news.ycombinator.com/newest";
	public static String askPage = "http://news.ycombinator.com/ask";
	public static String jobsPage = "http://news.ycombinator.com/jobs";
	public static String submitPage = "http://news.ycombinator.com/submit";
	public static String votePage = "http://news.ycombinator.com/vote?for=";
	
	public static String fnlinkPage(String fnlink)
	{
		return homePage + fnlink;
	}
	public static String voteFor(String id)
	{
		return votePage + id;
	}

}
