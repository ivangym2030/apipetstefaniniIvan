package com.example.petstefanini.infrastructure.Util;

import java.time.LocalDate;
import java.util.UUID;


import com.example.petstefanini.infrastructure.entity.ErrorResponse;


	public final class FormatUtils {

	    
	    private FormatUtils() {
	       
	    }
	
	public static String getLocalTimeNow() {
		return LocalDate.now().toString();
	}
	
	public static String getRandomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	 public static ErrorResponse getError(String code,String message,String type ) {
		 ErrorResponse error = new ErrorResponse();
			
	          error.setCode(code);
	          error.setMessage(message);
	          error.setType(type);
	          return error;
	 }
	 
	 
	 
 }


