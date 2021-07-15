package com.albo.marvel.model;

import java.io.Serializable;

public class Thumbnail implements Serializable{
	
	private static final long serialVersionUID = -1661446814206726694L;
	private String path;
	private String extension;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	

}
