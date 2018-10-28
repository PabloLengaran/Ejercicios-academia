package Fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test() {
		Fibonacci f = new Fibonacci();
		assertEquals(13, f.fibonacci(7));
	}

}
