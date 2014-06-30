package com.neerajb.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RelatedUrlGenerator {
	
	//http://www.imr-journal.com/article/PIIS2213422013000656/related
	List<String> domainsList = new ArrayList<String>();
	{
		domainsList.add("http://www.imr-journal.com/article/");
		domainsList.add("http://www.heartlungcirc.org/article/");
		domainsList.add("http://www.homeopathyjournal.net/article/");
		domainsList.add("http://www.rheumatic.theclinics.com/article/");
		domainsList.add("http://www.rv-medicine.com/article/");
		domainsList.add("http://www.radiographyonline.com/article/");
		domainsList.add("http://www.radiologic.theclinics.com/article/");
	}
	
	public List<String> generateUrls(Set<String> piis){
		List<String> generatedUrls = new ArrayList<String>();
		
		for(String domain : domainsList){
			for(String pii : piis){
				generatedUrls.add(domain+pii+"/related");
			}
		}
		
//		System.out.println("generated related urls size:"+generatedUrls.size());
//		for(String url : generatedUrls){
//			System.out.println(url);
//		}
		return generatedUrls;
	}
}
