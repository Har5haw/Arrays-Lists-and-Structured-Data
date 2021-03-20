package KnownLanguageAndKnownKeyLength;


/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.*;
public class CaesarCipher {
    private String alphabet;
    private String encryptShiftedAlphabet;
    private String decryptShiftedAlphabet;

    public CaesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        encryptShiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        decryptShiftedAlphabet = alphabet.substring(26 - key) + alphabet.substring(0, 26 - key);
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
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char originalCh = sb.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char decryptedCh = decryptShiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    sb.setCharAt(i, Character.toUpperCase(decryptedCh));
                } else {
                    sb.setCharAt(i, decryptedCh);
                }
            }
        }
        return sb.toString();
    }
}