package util;

import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.DigestUtils;

public class CriptografiaUtil {

    private static final  String SALT = "2b4abe710311fbc0d8d9f4c069227f5d";

    public static String criptografar(String texto) {
        return Crypt.crypt(texto , SALT);
    }

    public static void main(String[] args) {
        System.out.println(criptografar("Wpadmin321"));
    }

}
