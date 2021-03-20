package KnownLanguageAndUnknownKeyLength;


import edu.duke.*;
import java.util.*;
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
        FileResource dictionaryFile = new FileResource();
        HashSet < String > dictionary = readDictionary(dictionaryFile);
        return breakForLanguage(input, dictionary);
    }

    public HashSet < String > readDictionary(FileResource fr) {
        HashSet < String > dictionary = new HashSet < String > ();
        for (String line: fr.lines()) {
            dictionary.add(line.toLowerCase());
        }
        return dictionary;
    }

    public int countWords(String input, HashSet < String > dictionary) {
        String[] words = input.split("\\W+");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (dictionary.contains(words[i].toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String input, HashSet < String > dictionary) {
        int maxCount = 0;
        String finalDecryption = "";
        for (int i = 1; i <= 100; i++) {
            int[] key = tryKeyLength(input, i, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String decrypt = vc.decrypt(input);
            int count = countWords(decrypt, dictionary);
            if (maxCount < count) {
                maxCount = count;
                finalDecryption = decrypt;
            }
        }
        return finalDecryption;
    }

    
}