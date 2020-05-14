package com.peraton.wmss.ingest;

public class WebDataFactory {
	
	public webdata getWebData(String webDataType) {
		if (webDataType == null) {
			return null;
		} else if (webDataType == "XML") {
			return new xmldocument();
		} else if (webDataType == "JSON") {
			return new jsondocument();
		} else if (webDataType == "TEXT") {
			return new textdocument();
		}
		return null;
	}

}
