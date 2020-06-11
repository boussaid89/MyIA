package com.myia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myia.entity.User;


public class AbstractDAO {
	protected ObjectMapper mapper = new ObjectMapper();
	protected EntityResolver<User> userResolver=new EntityResolver<User>(User.class);

	
	
	
	protected String jsonFromEntity(Object obj) {
		String retour = "";
		try {
			retour = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return retour;
		
	}
	 
		
}
