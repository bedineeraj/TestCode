package com.neerajb.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


public class XmlParser {
	
	public Set<String> getUrls(){
		String readContents;
		try {
			readContents = FileUtils.readFileToString(new File("c:/delete/source.txt"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("error reading file");
		}
		String[] substringsBetween = StringUtils.substringsBetween(readContents, "openArticle('", "','_self');");
//		System.out.println(substringsBetween.length);
//		System.out.println(substringsBetween);
		Set<String> urls = new HashSet<String>();
		urls.addAll(Arrays.asList(substringsBetween));
//		System.out.println("urls size:"+urls.size());
//		System.out.println("urls:"+urls);
		return urls;
	}
	

	public Set<String> getPiis(){
		Set<String> urls = getUrls();
		Set<String> piis = new HashSet<String>();
		for(String url : urls){
			String pii = StringUtils.substringBetween(url, "article/","/");
			if(StringUtils.isNotBlank(pii)){
				piis.add(pii);
			}
		}
//		System.out.println("piis size:"+piis.size());
//		System.out.println("pii list:"+piis);
		return piis;
	}
}
