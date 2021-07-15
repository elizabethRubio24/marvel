package com.albo.marvel.model;

import java.io.Serializable;
import java.util.List;

public class CharacterComic implements Serializable{
	
	private static final long serialVersionUID = -1661446814206726694L;
	
	private String character;
	private List<String> comic;
	
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public List<String> getComic() {
		return comic;
	}
	public void setComic(List<String> comic) {
		this.comic = comic;
	}
	

}
