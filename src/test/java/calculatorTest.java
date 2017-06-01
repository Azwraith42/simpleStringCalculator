package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.SimpleStringCalculator;

public class calculatorTest {

	/*@Test(expected = RuntimeException.class)
	public void whenMoreThanTwoNumbersThrowException(){
		SimpleStringCalculator.add("1,2,3");
	}*/
	
	@Test
	public void emptyStringReturnZero(){
		final int result = SimpleStringCalculator.add("");
		assertEquals(0, result);
	}
	
	@Test
	public void returnTheResultOfTheAddition(){
		final int result = SimpleStringCalculator.add("1,3");
		assertEquals(4, result);
	}
	
	@Test
	public void methodCanTakeUpToTwoArguments(){
		SimpleStringCalculator.add("1,2");
		assertTrue(true);
	}
	
	@Test(expected = RuntimeException.class)
	public void ifNonNumberIsUsedThrowException(){
		SimpleStringCalculator.add("1,X");
	}
	
	@Test
	public void allowAnyNumberOfNumbers(){
		SimpleStringCalculator.add("1,2,5,4,77,9");
	}
	
	@Test
	public void allowNewLinesBetweenNumbers(){
		final int result = SimpleStringCalculator.add("1\n2,3");
		assertEquals(6, result);
	}
	
	@Test
	public void supportDifferentDelimiters(){
		final int result = SimpleStringCalculator.add("//;\n1;2");
		assertEquals(3, result);
	}
	
	@Test
	public void numbersBiggerThanOneThousandShouldBeIgnored(){
		final int result = SimpleStringCalculator.add("2,1001");
		assertEquals(2, result);
	}
	
	@Test(expected = RuntimeException.class)
	public void negativesNotAllowed(){
		final int result = SimpleStringCalculator.add("2,-6");
		assertEquals(3, result);
	}
}
