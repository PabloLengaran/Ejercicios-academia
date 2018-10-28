package Factorial;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void test() {
		Factorial f= new Factorial();
		assertEquals(120, f.factorial(5));
		
		
	}

}
