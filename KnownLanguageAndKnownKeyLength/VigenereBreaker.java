package KnownLanguageAndKnownKeyLength;

import edu.duke.*;
public class VigenereBreaker {
    public String sliceString(String input, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder(input);
        String newString = "";
        for (int i = whichSlice; i < sb.length(); i += totalSlices) {
            newString += sb.charAt(i);
        }
        return newString;
    }

    public int[] tryKeyLength(String input, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCrack cc = new CaesarCrack(mostCommon);
        for (int i = 0; i < klength; i++) {
            key[i] = cc.getKey(sliceString(input, i, klength));
        }
        return key;
    }

    public String breakVigenere() {
        FileResource fr = new FileResource();
        String input = fr.asString();
        int[] key = tryKeyLength(input, 5, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String output = vc.decrypt(input);
        return output;
    }
}