package lab02;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

//import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class myDESCipherTest {

	@Test
	public void test1() {
		System.out.println("============= TEST1 =============");
		byte[] cipher;
		byte[] plain;
		byte[] keybytes;
		
		keybytes =  new BigInteger("13579BDF02468ACE",16).toByteArray();

		String message = new String("Alphabet");
		myDESCipher dc = new myDESCipher(keybytes);
		cipher = dc.encrypt(message.getBytes());
		System.out.println("Encrypted message: " + new String(cipher));

		byte[] ans = new BigInteger("5DEA6FA34EDDA339",16).toByteArray(); //returns leading zero for bit sign
		
		assertTrue(Arrays.equals(cipher,ans));
	  
		plain = dc.decrypt(cipher);

		System.out.println("Decrypted Ciphertext (hex): "+ new BigInteger(1, plain).toString(16).toUpperCase());
		System.out.println("Decrypted Ciphertext (ascii): "+ new String(plain));

		assertEquals(message, new String(plain));
	 }
	
	@Test
	public void test3() {
		System.out.println("============= TEST3 DECRYPTING CIPHER =============");
		byte[] keybytes;
		byte[] message;
		
		keybytes =  new BigInteger("13579BDF02468ACE",16).toByteArray();

		String cipher = "B4528C2E87081C4AD54A77EE912956AAD24CD1211E00623F";
		System.out.println("cipher: " + cipher);
		
		myDESCipher dc = new myDESCipher(keybytes);
		
		byte[] cipherBytes = new BigInteger(cipher, 16).toByteArray();
		
		message = dc.decrypt(cipherBytes);
		
		byte[] unpaddedMessage = removePadding(message);
		
		
	    System.out.println("Decrypted message (with padding): " + new String(message, StandardCharsets.UTF_8));
		System.out.println("Decrypted message: " + new String(unpaddedMessage, StandardCharsets.UTF_8));


	 }
	
	@Test
	public void test2() {
		System.out.println("============= TEST2 =============");
		byte[] cipher;
		byte[] plain;
		byte[] keybytes;
		
		String key = "13579BDF02468ACE";
		String iv  = "A0A1A2A3A4A5A6A7";
		
		String binaryString = new BigInteger(key, 16).toString(2);
		keybytes =  new BigInteger(binaryString,2).toByteArray();
		byte[] ivbytes = hextStringToByteArray(iv);
		System.out.println("Key: " + key.length());
		System.out.println("IVbytes:  " + iv.length());

		String message = new String("Second Test");
		System.out.println("Initial message: " + message);

		myDESCipher dc = new myDESCipher(keybytes,ivbytes);
		cipher = dc.encrypt(message.getBytes());
		System.out.println("Encrypted message: " + new String(cipher));

		byte[] leadingZero = new BigInteger("C9A476194958FB9716A59B869F5F4351",16).toByteArray(); //returns leading zero for bit sign
		byte[] ans = Arrays.copyOfRange(leadingZero, 1, leadingZero.length);
		
	    assertTrue(Arrays.equals(cipher,ans));
	  
		plain = dc.decrypt(cipher);
		System.out.println("Decrypted Ciphertext (hex): "+ new BigInteger(1, plain).toString(16).toUpperCase());
		System.out.println("Decrypted Ciphertext (ascii): "+ new String(plain));
		
		assertEquals(message, new String(plain));
	}
	
	public static byte[] hextStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len/2];
		for(int i=0;i<len;i+=2) {
			data[i/2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i+1), 16));
		}
		return data;
	}	
	public byte[] removePadding(byte[] decrypted) {
	    int padding = decrypted[decrypted.length - 1]; // Last byte indicates padding length
	    if (padding > 0 && padding <= 8) { // Check for valid padding length (1 to 8 for DES)
	        return Arrays.copyOf(decrypted, decrypted.length - padding); // Remove padding bytes
	    }
	    return decrypted; // Return original if no valid padding found
	}
}
