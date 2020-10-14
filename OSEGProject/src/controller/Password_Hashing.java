package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password_Hashing {
	 //MD-5 Algo for Password
    public  String get_SecurePassword(String passwordToHash) throws UnsupportedEncodingException
    {
        String generatedPassword = passwordToHash;
        System.out.println(passwordToHash);
        System.out.println(generatedPassword);
            try {
                 MessageDigest md = MessageDigest.getInstance("SHA-256");
                 
                 byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
                 StringBuilder sb = new StringBuilder();
                 for(int i=0; i< bytes.length ;i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                 }
                 generatedPassword = sb.toString();
                } 
               catch (NoSuchAlgorithmException e){
                e.printStackTrace();
               }
            return generatedPassword;    
        }
}
