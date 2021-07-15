package com.albo.marvel.response;

import java.util.List;

import com.albo.marvel.model.CharacterComic;

public class MarvelResponseCharacter {
	
	private String last_sync;
	
	List<CharacterComic> lstCharacterComic;

	public String getLast_sync() {
		return last_sync;
	}

	public void setLast_sync(String last_sync) {
		this.last_sync = last_sync;
	}

	public List<CharacterComic> getLstCharacterComic() {
		return lstCharacterComic;
	}

	public void setLstCharacterComic(List<CharacterComic> lstCharacterComic) {
		this.lstCharacterComic = lstCharacterComic;
	}

}
