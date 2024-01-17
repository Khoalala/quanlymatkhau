package service;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHash {
    
    // Số lần lặp càng cao thì càng nhiều
     // việc tính toán tốn kém.
	
    private static final int iterations = 20*1000;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    /** Tính toán hàm băm PBKDF2 của mật khẩu văn bản gốc đã 
         tích hợp để lưu trữ trong cơ sở dữ liệu.
         Mật khẩu trống không được hỗ trợ. */
    public static String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // lưu bản mã của trữ mật khẩu
        //return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
        return Base64.getEncoder().encodeToString(salt)+ "$" + hash(password, salt);
    }

    /** Kiểm tra xem mật khẩu văn bản gốc đã cho có tương ứng hay không
         vào hàm băm salt được lưu trữ của mật khẩu. */
    public static boolean checkPassword(String password, String stored) throws Exception{
        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                "The stored password must have the form 'salt$hash'");
        }
        //String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
        String hashOfInput = hash(password, Base64.getDecoder().decode(saltAndHash[0]));
        
        return hashOfInput.equals(saltAndHash[1]);
    }

    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
            password.toCharArray(), salt, iterations, desiredKeyLen));
        //return Base64.encodeBase64String(key.getEncoded());
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
