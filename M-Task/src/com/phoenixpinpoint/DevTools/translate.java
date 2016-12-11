/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 
 * 
 * Class: translate
 * Version: 62720161628
 * 
 * 
 * Support: 
 * *********************************************/
package com.phoenixpinpoint.DevTools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class translate {
    private static MessageDigest digester;

    static {
        try {
            digester = MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }
	
    public static void main(String[] args)
	{
		String md5crypted = crypt("Pnc123458");
		System.out.println(md5crypted);
		
	}
}
