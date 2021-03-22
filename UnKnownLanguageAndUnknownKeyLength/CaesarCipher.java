package UnKnownLanguageAndUnknownKeyLength;

/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.*;
public class CaesarCipher {
    private int key;
    private String alphabet;
    private String encryptShiftedAlphabet;

    public CaesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.key = key;
        encryptShiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char originalCh = sb.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char encryptedCh = encryptShiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    sb.setCharAt(i, Character.toUpperCase(encryptedCh));
                } else {
                    sb.setCharAt(i, encryptedCh);
                }
            }
        }
        return sb.toString();
    }

    public String decrypt(String input) {
        KnownLanguageAndKnownKeyLength.CaesarCipher caesarCipher = new KnownLanguageAndKnownKeyLength.CaesarCipher(26 - key);
        return caesarCipher.encrypt(input);
    }
}