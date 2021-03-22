package Assignment_2_CaesarCipher;

import java.lang.*;
import java.util.Scanner;

import edu.duke.*;
public class CaesarCipher {

    public static String encrypt(String input, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encryptShiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
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

    public static String encryptTwoKeys(String input, int key1, int key2){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encryptShiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i = 0; i < stringBuilder.length(); i+=2) {
            char originalCh = stringBuilder.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char encryptedCh = encryptShiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    stringBuilder.setCharAt(i, Character.toUpperCase(encryptedCh));
                } else {
                    stringBuilder.setCharAt(i, encryptedCh);
                }
            }
        }
        encryptShiftedAlphabet = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 1; i < stringBuilder.length(); i+=2) {
            char originalCh = stringBuilder.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(originalCh));
            if (idx != -1) {
                char encryptedCh = encryptShiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(originalCh)) {
                    stringBuilder.setCharAt(i, Character.toUpperCase(encryptedCh));
                } else {
                    stringBuilder.setCharAt(i, encryptedCh);
                }
            }
        }

        return stringBuilder.toString();
    }

    public void testCaesar(){
        Scanner sc = new Scanner(System.in);
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("enter key");
        int key = sc.nextInt();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
}
