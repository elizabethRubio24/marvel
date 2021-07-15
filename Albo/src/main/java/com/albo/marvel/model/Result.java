package com.albo.marvel.model;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable{
	
	private static final long serialVersionUID = -1661446814206726694L;
	private Integer id;
	private String name;
	private String description;
	private String modified;
	private Thumbnail thumbnail;
	private String resourceURI;
	private Comic comics;
	private Serie series;
	private Story stories;
	private Event events;
	private List<Url> urls;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public Thumbnail getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public Comic getComics() {
		return comics;
	}
	public void setComics(Comic comics) {
		this.comics = comics;
	}
	public Serie getSeries() {
		return series;
	}
	public void setSeries(Serie series) {
		this.series = series;
	}
	public Story getStories() {
		return stories;
	}
	public void setStories(Story stories) {
		this.stories = stories;
	}
	public Event getEvents() {
		return events;
	}
	public void setEvents(Event events) {
		this.events = events;
	}
	public List<Url> getUrls() {
		return urls;
	}
	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}
	
	
}
