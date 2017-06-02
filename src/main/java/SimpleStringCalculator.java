package main.java;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class SimpleStringCalculator {

	public static int add(String numbers) {
		
		int total = 0;
		if(numbers == ""){return 0;}
		
		final String delims = "[//\\\\;,\n]+";
		String[] tokens = numbers.split(delims);
		
		int[] intArray = makeIntArray(tokens);
		
		for(int i=0; i<intArray.length;i++){
			
			total += intArray[i] <= 1000 ? intArray[i] : 0;
		}
				
		return total;
	}

	private static int[] makeIntArray(String[] tokens) {
		final int n = tokens.length;
		final int[] newIntArray = new int[n];

		for(int i=0, j=0; i<tokens.length; i++){
			if(StringUtils.isNumeric(tokens[i])){
				newIntArray[j++] = Integer.parseInt(tokens[i]);
			}else if(!StringUtils.isAlphanumeric(tokens[i])){
				if(NumberUtils.isNumber(tokens[i])){
					throw new RuntimeException();
				}
				continue;
			}else{
				throw new RuntimeException();
			}
		}
		
		return newIntArray;
	}

}
