package lab01;

public class Caesar {	
	
	//encodes single character with Caesar shift
	static char rot(char c, int shift) {  
		// lower case
		if (c >= 'a' && c <= 'z') {
			return (char) ('a' + (c - 'a' + shift) % 26);
		}
		
		// upper case
				if (c >= 'A' && c <= 'Z') {
					return (char) ('A' + (c - 'A' + shift) % 26);
				}
		
		return c;
	}
	
//	static char charAdd(char c, char k)
//	{  
//		//TODO
//	}
//	
	// encodes string with Caesar shift
	static String caesarEncrypt(String str, int shift) {
		char[] charArray = str.toCharArray();
		
		
		for (char c: charArray) {
			rot(c, shift);
		}
		String encodedStr = new String(charArray);
		return encodedStr;
    }
//	
//	static String caesarDecrypt(String str, int shift)
//    {
//		// TODO
//    }
//		
//	static String vigenereEncrypt(String str, String key)
//    {
//		// TODO
//    }
//	
//	static char inverseChar(char c)
//	{
//		// TODO
//	}
//	
//	
//	static String vigenereDecrypt(String str, String key)
//	{
//		// TODO
//	}
//	 
	
}
