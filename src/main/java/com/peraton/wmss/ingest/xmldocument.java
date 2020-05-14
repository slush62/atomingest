package com.peraton.wmss.ingest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class xmldocument implements webdata {

	@Override
	public String retrieve(String aUrl) throws ClientProtocolException, IOException {
		String webContent = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			//System.out.println(aURL);
			HttpGet request = new HttpGet(aUrl);
			request.addHeader("accept","text/xml");
			request.addHeader("accept","application/xml");
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				// Get HttpResponse Status
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						webContent = EntityUtils.toString(entity);
					}
				} else {
					System.out.println("HTTP Response: "+response.getStatusLine().getStatusCode()+"\n"+response.getStatusLine().getReasonPhrase());
				}
			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}
		return webContent;
	}

}
