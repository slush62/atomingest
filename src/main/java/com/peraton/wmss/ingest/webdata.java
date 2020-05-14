package com.peraton.wmss.ingest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface webdata {
	public String retrieve(String url) throws ClientProtocolException, IOException;
}
