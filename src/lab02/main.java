package lab02;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class main {
	Cipher ecipher;  // DES encryption cipher 
	Cipher dcipher;  // DES decryption cipher
	
	byte[] keybytes = new BigInteger("13579BDF02468ACE",16).toByteArray();
	String message = new String("B4528C2E87081C4AD54A77EE912956AAD24CD1211E00623");
	main dc = new main(keybytes);
	cipher = dc.encrypt(message.getBytes());
	System.out.println("Encrypted message: " + new String(cipher));
	
	main(byte[] keyBytes, byte[] ivBytes){
		SecretKey key = new SecretKeySpec(keyBytes, "DES");
		IvParameterSpec iv = new IvParameterSpec(ivBytes);
		try{
			/* TODO:  set ecipher to be a DES encryption cipher in CBC mode with PKCS5 padding and ivBytes as initialisation vector */
			ecipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			ecipher.init(Cipher.ENCRYPT_MODE, key, iv);
			
			/* TODO:  set dcipher to be a DES encryption cipher in CBC mode with PKCS5 padding and ivBytes as initialisation vector */
			dcipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			dcipher.init(Cipher.DECRYPT_MODE, key, iv);
		}
		catch (InvalidKeyException e){
		}
		catch (NoSuchAlgorithmException e){
		}
		catch (NoSuchPaddingException e){
		} 
		catch (InvalidAlgorithmParameterException e){			
		}
	}
	
	main(byte[] keybytes){
		SecretKey key = new SecretKeySpec(keybytes, "DES");
		try{
			/* TODO set ecipher to be a DES encryption cipher in ECB mode with no padding	*/
			ecipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			/* TODO set dcipher to be a DES decryption cipher in ECB mode with no padding	*/
			dcipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			dcipher.init(Cipher.DECRYPT_MODE, key);
			}
		catch (InvalidKeyException e){
		}
		catch (NoSuchAlgorithmException e){
		}
		catch (NoSuchPaddingException e){
		} 
	 }


	public byte[] encrypt(byte[] databytes){
		byte[] enc = null;
		try{
			/* TODO encrypt databytes with ecipher */
			enc = ecipher.doFinal(databytes);
		}
		catch (IllegalBlockSizeException e){
		}
		catch (BadPaddingException e){
		}
		return enc;
	}

	public byte[] decrypt(byte[] databytes){
		byte[] dec = null;
		try{
			/* TODO decrypt databytes with ecipher */
			dec = dcipher.doFinal(databytes);
		}
		catch (IllegalBlockSizeException e){
		}
		catch (BadPaddingException e){
		}
		return dec;
	}
	
}