package com.albo.marvel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.marvel.constants.MarvelConstants;
import com.albo.marvel.model.CharacterComic;
import com.albo.marvel.model.CharacterDto;
import com.albo.marvel.model.EventDto;
import com.albo.marvel.model.Item;
import com.albo.marvel.model.ItemCreator;
import com.albo.marvel.model.RelatedCharacterDto;
import com.albo.marvel.model.ResultRelatedCharacter;
import com.albo.marvel.response.MarvelResponseColaborator;
import com.albo.marvel.response.MarvelResponseCharacter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import us.monoid.json.JSONException;
import us.monoid.web.Resty;
import org.apache.commons.codec.digest.DigestUtils;  

@RestController
@RequestMapping("/marvel")
public class MarvelController {

	@GetMapping("/colaborators/{character}")
	public Marvel marvelColaborators(@PathVariable String character) throws JSONException, IOException {
		MarvelResponseColaborator response = new MarvelResponseColaborator();
		List<String> writers  =new ArrayList<String>();
		List<String> editors  =new ArrayList<String>();
		List<String> colorists  =new ArrayList<String>();
		String lastSync=null;
		String id=null;

	    String stringToHash = MarvelConstants.timeStamp + MarvelConstants.privateKey + MarvelConstants.publicKey;
	    String hash = DigestUtils.md5Hex(stringToHash);
	        
	    if(character.equals(MarvelConstants.IRONMAN)){
	    	id=MarvelConstants.ID_IRONMAN;
	    }
	    else {
	    	if(character.equals(MarvelConstants.CAPAMERICA)){
	    		id=MarvelConstants.ID_CAPAMERICA;
	        }
	    }
	    String url = String.format("https://gateway.marvel.com:443/v1/public/characters/" + id +"?ts=%d&apikey=%s&hash=%s&limit=%d", MarvelConstants.timeStamp, MarvelConstants.publicKey, hash, MarvelConstants.limit);
	    	
	    try { 
	              
	    	String output = new Resty().text(url).toString();
	    	ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        CharacterDto characterDto = objectMapper.readValue(output, CharacterDto.class);	  
    
	        List<Item> events=characterDto.getData().getResults().get(0).getEvents().getItems();
	        List<ItemCreator> creators=null; 
          
	        for(Item item : events) {            	  
	        	String urlEvent = String.format(item.getResourceURI() +"?ts=%d&apikey=%s&hash=%s&limit=%d", MarvelConstants.timeStamp, MarvelConstants.publicKey, hash, MarvelConstants.limit);
	        	String outputEvent= new Resty().text(urlEvent).toString();
		        ObjectMapper objectMapperEvent = new ObjectMapper();
		        objectMapperEvent.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		        EventDto eventDto = objectMapperEvent.readValue(outputEvent, EventDto.class);	
		        creators=eventDto.getData().getResults().get(0).getCreators().getItems();	   
		        lastSync=eventDto.getData().getResults().get(0).getModified();
	       }
	              
	       for(ItemCreator creator : creators) {
	    	   if(creator.getRole().equals("writer")) {
	    		   writers.add(creator.getName());
	           }
	           if(creator.getRole().equals("colorist")) {
	           	   colorists.add(creator.getName());
	           }
	           if(creator.getRole().equals("editor")) {
	        	   editors.add(creator.getName());
	           }
	      }
	            	  
	      response.setLast_sync(lastSync);
	      response.setWriters(writers);
	      response.setEditors(editors);
	      response.setColorists(colorists);
		        
	} catch (Exception ex) {
	            ex.printStackTrace();
	}
		
	ObjectMapper mapper = new ObjectMapper();
	String json = mapper.writeValueAsString(response);
	return new Marvel( json);
}
	
	
	@GetMapping("/characters/{character}")
	public Marvel marvelCharacteres(@PathVariable String character) throws JSONException, IOException {		
		MarvelResponseCharacter responseCharacter = new MarvelResponseCharacter();
				
		List<CharacterComic> relatedCharacterList  =new ArrayList<CharacterComic>();
		
		String lastSync=null;
	    String id=null;

	    String stringToHash = MarvelConstants.timeStamp + MarvelConstants.privateKey + MarvelConstants.publicKey;
	    String hash = DigestUtils.md5Hex(stringToHash);
	        
	    if(character.equals(MarvelConstants.IRONMAN)){
	    	id=MarvelConstants.ID_IRONMAN;
	    }
	    else {
	    	if(character.equals(MarvelConstants.CAPAMERICA)){
	    		id=MarvelConstants.ID_CAPAMERICA;
	        }
	    }
	    String url = String.format("https://gateway.marvel.com/v1/public/characters/" + id +"/series?ts=%d&apikey=%s&hash=%s&limit=%d", MarvelConstants.timeStamp, MarvelConstants.publicKey, hash, MarvelConstants.limit);
	    	try { 
	    		String output = new Resty().text(url).toString();
                ObjectMapper objectMapper = new ObjectMapper();
	            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	            RelatedCharacterDto relatedCharacterDto = objectMapper.readValue(output, RelatedCharacterDto.class);	  
	            List<ResultRelatedCharacter> lstResultRelatedCharacter=relatedCharacterDto.getData().getResults();
	            for(ResultRelatedCharacter resultRelatedCharacter : lstResultRelatedCharacter ) {  
	            	  CharacterComic characterComic = new CharacterComic();	
	            	  for(Item item : resultRelatedCharacter.getCharacters().getItems()) {	            		 
	            		 List <String> comics = new ArrayList<String>();	            		 
	            		             		 
	            		 characterComic.setCharacter(item.getName());
	            		 for(Item itemComic : resultRelatedCharacter.getCharacters().getItems() ) {
	            			 comics.add(itemComic.getName());            			 
	            		 }
	            		 characterComic.setComic(comics);
	            	 }  
	            	 relatedCharacterList.add(characterComic); 
	            	 
	              }
	              lastSync =  lstResultRelatedCharacter.get(0).getModified();
	              responseCharacter.setLast_sync(lastSync);
	              responseCharacter.setLstCharacterComic(relatedCharacterList);

	          } catch (Exception ex) {
	            ex.printStackTrace();
	          }
	    	   ObjectMapper mapper = new ObjectMapper();
	        String json = mapper.writeValueAsString(responseCharacter);

		return new Marvel( json);
	}
}
