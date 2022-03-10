package security;

import org.apache.commons.codec.binary.Base64;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AuthenticationManager {

    public static final String ALGORITHM = "AES";
    public static final String keyValue  = "1A3B5C7D9E1F3G5H"; //should by 16 bytes


    public static Key generateKey(){
        return new SecretKeySpec(keyValue.getBytes(), ALGORITHM);
    }

    public static String encode(String password) {
        Key key = generateKey();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException |NoSuchPaddingException e) {
            e.printStackTrace();
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] encValue = new byte[0];
        try {
            encValue = cipher.doFinal(password.getBytes());
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        byte[] encByteValue = new Base64().encode(encValue);

        return new String(encByteValue);
    }

    public static String decode(String passwordEncrypted){
        Key key = generateKey();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException |NoSuchPaddingException e) {
            e.printStackTrace();
        }

        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] decodedBytes = new Base64().decode(passwordEncrypted);

        byte[] decryptedValue = new byte[0];
        try {
            decryptedValue = cipher.doFinal(decodedBytes);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return new String(decryptedValue);
    }

    public static boolean isAuthenticated(String passwordEncrypted, String passwordEntered){
        if (passwordEncrypted.isEmpty() || passwordEntered.isEmpty())
            return false;

        return passwordEntered.equals( decode(passwordEncrypted));
    }
}


