package com.albo.marvel.model;

import java.io.Serializable;
import java.util.List;

public class Comic  implements Serializable{
	
	private static final long serialVersionUID = -1661446814206726694L;
	private Integer available;
	private String collectionURI;
	private List<Item> items;
	private Integer returned;
	
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public String getCollectionURI() {
		return collectionURI;
	}
	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Integer getReturned() {
		return returned;
	}
	public void setReturned(Integer returned) {
		this.returned = returned;
	}
	
	

}
