package CountX;

public class CountX {

//	Given a string, compute recursively (no loops) the number of lowercase 'x'
//	chars in the string.

	public int countX (String text) {
		if(text.length() == 1) {
			if (!text.equals("x")) {
				return 0;
			}else{
				return 1;
			}
		} else {
			String text1 = text.substring(text.length()/2, text.length());
//			String text2 = text.substring();
			return countX(text1) ;
//			+ countX(text2)
		}
		
	}
	
}
