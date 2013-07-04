package com.oguzdev.hnclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.oguzdev.hnclient.utils.BadStatusException;



public class Http 
{
	public static String downloadPage(String urlText) throws IOException, BadStatusException
	{
		HttpClient client = new DefaultHttpClient();		
		HttpGet request = new HttpGet(urlText);
		
		HttpResponse response = client.execute(request);
		
		if(response.getStatusLine().getStatusCode() != 200)
		{
			//System.out.println("HTTP "+response.getStatusLine().getStatusCode());
			throw new BadStatusException(response.getStatusLine().getStatusCode());
		}
		
		BufferedReader rd = new BufferedReader
			(new InputStreamReader(response.getEntity().getContent()));
				    
		String page = "", line;
		while ((line = rd.readLine()) != null) {	
			page += line;
		} 
		return page;
		
	}
}
