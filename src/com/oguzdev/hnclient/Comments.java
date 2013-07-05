package com.oguzdev.hnclient;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.oguzdev.hnclient.utils.BadStatusException;

public class Comments 
{
	public static final int MAXIMUM_DEEPNESS = 50;
	
	private String pageUrl;
	private ArrayList<CommentItem> commentsList;
	
	private String pageContent;
	
	public Comments(String url)
	{
		pageUrl = url;
	}
	
	public void download() throws IOException, BadStatusException
	{
		pageContent = Http.downloadPage(pageUrl);
	}
	
	/*
	 * Try to iterate in YCombinator's horrible HTML table structure and parse it.
	 */
	public void parse()
	{
		commentsList = new ArrayList<CommentItem>();
		Document doc = Jsoup.parse(pageContent);
		
		try
		{
			// Find our comments container
			Element container = doc.getElementsByTag("table").first().
									getElementsByTag("tr").get(3).
									getElementsByTag("td").first();
			// In this container, every <table> is a comment,
			// except the first one.
			
			Elements tables = container.getElementsByTag("table");
			
			// Start from the second table, because the first one is the original post
			for(int e=1; e<tables.size(); e++)
			{
				// Another try/catch here, 
				// so that if there is an exception in one comment, we can move on 
				try
				{
					CommentItem comment = new CommentItem();
					
					Element ctable = tables.get(e);
					// The depth of the comment is the width of an invisible image
					// this sucks.
					comment.setDepth(Integer.parseInt(ctable.getElementsByTag("img").first().attr("width"))/40);
					
					Element chead = ctable.getElementsByClass("comhead").first();
					Elements aheads = chead.getElementsByTag("a");
					
					// check if there is a username
					if(aheads==null || aheads.size()==0)
						continue;
					
					// Set username from one of a elements
					comment.setUsername(aheads.get(0).text());
					
					// Set username from the other a element
					comment.setCommentLink(aheads.get(1).attr("href"));
					
					// Now remove a elements from chead then get the time
					for(Element child : chead.children())
						child.remove();
					
					// Set the comment time
					comment.setCommentTime(chead.text());
					
					// Find comment body from a span with class 'comment'
					comment.setCommentText(ctable.getElementsByClass("comment").first().text());	
					
					// Finally, add our comment to the single depth comments list
					commentsList.add(comment);
					
					// Now,
					for(int c=1; c<commentsList.size(); c++)
					{
						//if(flatCommentsList.get(c).getDepth()!=0)
					}
				}
				catch(Exception ec)
				{
					System.out.println("e "+e);
					ec.printStackTrace();
					continue;
				}
			}
			
			// Now we have a comments list with single depth.
			// It's time to create a hierarchy
		}
		catch(Exception e)
		{
			// Parse error. the page is not exactly like we expected.
			e.printStackTrace();
			return;
		}
	}
	
	public ArrayList<CommentItem> getComments()
	{
		return commentsList;
	}

}
