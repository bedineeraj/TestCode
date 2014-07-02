package com.neerajb.main;

import java.util.List;

import com.neerajb.http.HttpClient;

public class NewClass extends Thread{
	
	private List<String> listUrls;
	
	
	public NewClass(List<String> listUrls){
		this.listUrls = listUrls;
	}
	
	public void run(){
		for(String url : listUrls){
			HttpClient httpClient = new HttpClient();
//			System.out.println("Thread:"+getName());
			httpClient.connect(url);	
		}
	}
}
