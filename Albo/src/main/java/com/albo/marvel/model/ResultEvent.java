package com.albo.marvel.model;

import java.io.Serializable;
import java.util.List;

public class ResultEvent implements Serializable{
	
	private static final long serialVersionUID = -1661446814206726694L;
	
	private Integer id;
	private String title;
	private String description;
	private String resourceURI;
	private List<Url> urls;
	private String modified;
	private String start;
	private String end;
	private Thumbnail thumbnail;
	private Creator creators;
	private Character characters;
	private Story stories;
	private Comic comics;
	private Serie series;
	private Next next;
	private Previous previous;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public List<Url> getUrls() {
		return urls;
	}
	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Thumbnail getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Creator getCreators() {
		return creators;
	}
	public void setCreators(Creator creators) {
		this.creators = creators;
	}
	public Character getCharacters() {
		return characters;
	}
	public void setCharacters(Character characters) {
		this.characters = characters;
	}
	public Story getStories() {
		return stories;
	}
	public void setStories(Story stories) {
		this.stories = stories;
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
	public Next getNext() {
		return next;
	}
	public void setNext(Next next) {
		this.next = next;
	}
	public Previous getPrevious() {
		return previous;
	}
	public void setPrevious(Previous previous) {
		this.previous = previous;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
