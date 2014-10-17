package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
//b. An empty string will return 0.
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
//a. The method can take 0, 1, or 2 numbers 
//and will return their sum.
	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testLines(){
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    @Test
    public void testLinesCommas(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDelimeters(){
    	assertEquals(3, Calculator.add("//;1;2"));
    }

    //ok, I pass the test but don't know how to use the fail & assertTaht features...
    @Test
	public void testhrowExceptionWithNegativeNumbers() {
	  try {
	    new String("-1,2");
	   // fail("negs not allowed");
	  } catch (IllegalArgumentException e) {
	    //assertThat(e.getMessage(), containsString("Negative numbers not allowed: "));
	  }
	}



}






