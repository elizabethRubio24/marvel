package com.albo.marvel.model;

import java.io.Serializable;

public class Url implements Serializable {

	private static final long serialVersionUID = -1661446814206726694L;
	private String type;
	private String url;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
