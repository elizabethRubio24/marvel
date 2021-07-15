package com.albo.marvel.model;

import java.io.Serializable;

public class Item implements Serializable {
	
	private static final long serialVersionUID = -1661446814206726694L;
	private String resourceURI;
	private String name;
	
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
