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
	
	private static int counter = 0;
	public static int failureCounter = 0;
	
	public void connect(String strUrl){
		System.out.println("HttpCLient.counter:"+(counter++));
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(strUrl);
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpGet);
//			System.out.println(response1.getStatusLine());
			if(response1.getStatusLine().getStatusCode()!=200){
				++failureCounter;
			}
		    HttpEntity entity1 = response1.getEntity();
//		    String content = EntityUtils.toString(entity1);
//		    System.out.println("response contents:"+content);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    EntityUtils.consume(entity1);
		} catch (ClientProtocolException e) {
//			e.printStackTrace();
			++failureCounter;
		} catch (IOException e) {
//			e.printStackTrace();
			++failureCounter;
		}catch(Exception e){
//			e.printStackTrace();
			++failureCounter;
		}finally {
			if(response1!=null){
				try {
					response1.close();
					httpclient.close();
				} catch (IOException e) { e.printStackTrace(); }
			}
			System.out.println("failureCounter:"+failureCounter);
		}
	}
}
