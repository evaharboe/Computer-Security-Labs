package lab01;

public class Caesar {	
	
	//encodes single character with Caesar shift
	static char rot(char c, int shift) {  
		// lower case
		if (c >= 'a' && c <= 'z') {
			return (char) ('a' + (c - 'a' + (shift % 26 + 26)) % 26);
		}

		// upper case
		if (c >= 'A' && c <= 'Z') {
			return (char) ('A' + (c - 'A' + (shift % 26 + 26)) % 26);
		}

		return c;
	}

	static char charAdd(char c, char k) {
		if (Character.isLowerCase(c)) {
			k = Character.toLowerCase(k);
		}
		if (Character.isUpperCase(c)) {
			k = Character.toUpperCase(k);
		}
		
		// lower case
		if (c >= 'a' && c <= 'z' && k >= 'a' && k <= 'z') {
			return (char) ('a' + (c - 'a' + k - 'a') % 26);
		}
		
		//upper case
		if (c >= 'A' && c <= 'Z' && k >= 'A' && k <= 'Z') {
			return (char) ('A' + (c - 'A' + k - 'A') % 26);
		}
		
		return c;
	}
	
	// encodes string with Caesar shift
	static String caesarEncrypt(String str, int shift) {
		char[] charArray = str.toCharArray();
		String encodedStr = "";
		
		for (char c: charArray) {
			encodedStr += rot(c, shift);
			
		}
		return encodedStr;
    }

	static String caesarDecrypt(String str, int shift) {
		char[] charArray = str.toCharArray();
		String decodedStr = "";
		
		for (char c: charArray) {
			decodedStr += rot(c, -shift);
		}
		return decodedStr;
    }
		
	static String vigenereEncrypt(String str, String key) {
		char[] charArray = str.toCharArray();
		char[] keyArray = key.toCharArray();
		StringBuilder encodedStr = new StringBuilder();
		
		int keyLength = keyArray.length;
        int index = 0;
		
		for (char c: charArray) {
			if (c != ' ') {
				char keyChar = keyArray[index%keyLength];
				int shift;
				
				if (Character.isLowerCase(keyChar)) {
					shift = keyChar - 'a';
				} else {
					shift = keyChar - 'A';
				}
				
		        encodedStr.append(rot(c, shift));
		        index++;
			} else {
				encodedStr.append(' ');
			}
		}
		return encodedStr.toString();
	}
//	
//	static char inverseChar(char c)
//	{
//		// TODO
//	}
	
	static String vigenereDecrypt(String str, String key) {
		char[] charArray = str.toCharArray();
		char[] keyArray = key.toCharArray();
		StringBuilder decodedStr = new StringBuilder();
		
		int keyLength = keyArray.length;
		int index = 0;
		
		for (char c: charArray) {
			if (c != ' ') {
				char keyChar = keyArray[index%keyLength];
				int shift;
				
				if (Character.isLowerCase(keyChar)) {
					shift = 'a' - keyChar;
				} else {
					shift = 'A' - keyChar;
				}
				
				decodedStr.append(rot(c, shift));
				index++;
			} else {
				decodedStr.append(' ');
			}
		}
		return decodedStr.toString();
	}
	 
	
}
