package com.neerajb.main;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.neerajb.generators.RelatedUrlGenerator;
import com.neerajb.http.HttpClient;
import com.neerajb.parser.XmlParser;

public class MainClass {
	
	private static final int NO_OF_URLS = 1800;
	public static final int NO_OF_THREADS = 90;
	
	XmlParser parser = new XmlParser();
	RelatedUrlGenerator relatedUrlGenerator = new RelatedUrlGenerator();
	HttpClient httpClient = new HttpClient();
	
	public static void main(String[] args) throws IOException {
		MainClass obj = new MainClass();
		obj.execute();
	}
	
	public void execute(){
		Set<String> piis = parser.getPiis();
		List<String> listUrls = relatedUrlGenerator.generateUrls(piis);
		Set<String> fulltextUrls = parser.getUrls();
		listUrls.addAll(fulltextUrls);
		
		Collections.shuffle(listUrls);
//		System.out.println("========shuffled============="+listUrls.size());
//		for(String url : listUrls){
//			System.out.println(url);
//		}
		List<String> subList = listUrls.subList(0, NO_OF_URLS);
		System.out.println("subListSize:"+subList.size()+" mainListSize:"+listUrls.size());
		
//		System.out.println(subList);
//		httpClient.connect(subList.get(0));
		
		int urlsPerThread = NO_OF_URLS/NO_OF_THREADS;
		for(int threadId=0; threadId<NO_OF_THREADS; ++threadId){
			Thread t = new NewClass(listUrls.subList(threadId*urlsPerThread, (threadId+1)*urlsPerThread) );
			t.start();	
		}
		
		
		
	}
	
}
