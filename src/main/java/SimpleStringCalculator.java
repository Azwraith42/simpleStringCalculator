package main.java;

import org.apache.commons.lang3.StringUtils;

public class SimpleStringCalculator {

	public static int add(String numbers) {
		
		int total = 0;
		if(numbers == ""){return 0;}
		
		final String delims = "[/\\\\;,\n]+";
		String[] tokens = numbers.split(delims);
		
		
		for (int i = 0; i < tokens.length; i++){
		    //System.out.println(tokens[i]);
		    //System.out.println(StringUtils.isNumeric(tokens[i]));
		    
		    if(StringUtils.isAlpha(tokens[i])){
		    	throw new RuntimeException();
		    }else if(!StringUtils.isNumeric(tokens[i])){
		    	if(tokens[i].startsWith("-")){
		    		System.out.println("Negative Numbers not allowed;");
		    		throw new RuntimeException();
		    	}
		    	
		    }else{
		    	final int current = Integer.parseInt(tokens[i]);
		    	if(current > 1000){
		    		continue;
		    	}
		    	total += Integer.parseInt(tokens[i]);
		    }
		}
		// make sure they are all numbers
		
		// add them
		
		return total;
	}

}
