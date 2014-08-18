package com.neerajb.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {
	
	//this is just a test commit
	
	private static int counter = 0;
	public static int failCounter = 0;
	
	public void connect(String strUrl){
		System.out.println("HttpCLient.counter:"+(counter++));
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(strUrl);
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpGet);
			HttpEntity entity1 = response1.getEntity();
//			System.out.println(response1.getStatusLine());
			if(response1.getStatusLine().getStatusCode()!=200){
				System.out.println("url:"+strUrl);
				System.out.print(",status line:"+response1.getStatusLine());
				System.out.println(",response:"+EntityUtils.toString(entity1));
				++failCounter;
			}
		    
//		    String content = EntityUtils.toString(entity1);
//		    System.out.println("response contents:"+content);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    EntityUtils.consume(entity1);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			++failCounter;
		} catch (IOException e) {
			e.printStackTrace();
			++failCounter;
		}finally {
			if(response1!=null){
				try {
					response1.close();
					httpclient.close();
				} catch (IOException e) { e.printStackTrace(); }
			}
		}
	}
}
