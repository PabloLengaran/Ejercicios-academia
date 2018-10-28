package Fibonacci;

public class Fibonacci {

//	Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ...
//	Compute the result recursively (without loops).
	
	public int fibonacci (int f) {
		
		if (f == 0) {
			return 0;
		} else if (f == 1) {
			return 1;
		} else {
			return fibonacci(f-1) + fibonacci(f-2);
		}	
	}
	
}
