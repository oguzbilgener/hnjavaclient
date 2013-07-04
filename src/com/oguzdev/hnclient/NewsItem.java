package com.oguzdev.hnclient;

public class NewsItem 
{
	private String itemId;
	private String title;
	private String externalUrl;
	private String domain;
	private String pointsText;
	private String username;
	private String timeText;
	private String commentsText;
	
	public NewsItem()
	{
		itemId= title = externalUrl = domain = pointsText = username = timeText = commentsText = "";
	}
	
	public String toString()
	{
		return itemId+" | "+title+" \n"+externalUrl+" \n" + timeText + "by "+username+" ["+pointsText+"|"+commentsText+"]";
	}
	
	public void setItemId(String i)
	{
		itemId = i;
	}
	public void setTitle(String t)
	{
		title = t;
	}
	public void setExternalUrl(String e)
	{
		if(!e.startsWith("http"))
			e = Urls.homePage + e;
		externalUrl = e;
	}
	public void setDomain(String d)
	{
		domain = d;
	}
	public void setPoints(String p)
	{
		pointsText = p;
	}
	public void setUsername(String u)
	{
		username = u;
	}
	public void setTime(String t)
	{
		timeText = t;
	}
	public void setComments(String c)
	{
		if(c.equals("discuss"))
			c = "0 comments";
		commentsText = c;
	}
	
	public String getItemId()
	{
		return itemId;
	}
	public String getTitle()
	{
		return title;
	}
	public String getExternalUrl()
	{
		return externalUrl;
	}
	public String getDomain()
	{
		return domain;
	}
	public String getPoints()
	{
		return pointsText;
	}
	public String getUsername()
	{
		return username;
	}
	public String getTime()
	{
		return timeText;
	}
	public String getComments()
	{
		return commentsText;
	}
	
}
