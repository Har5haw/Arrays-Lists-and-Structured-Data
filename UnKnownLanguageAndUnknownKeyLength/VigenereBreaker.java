package UnKnownLanguageAndUnknownKeyLength;


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
        String[] langs = {
            "Danish",
            "Dutch",
            "English",
            "French",
            "German",
            "Italian",
            "Portuguese",
            "Spanish"
        };
        HashMap < String, HashSet < String >> allLangs = new HashMap < String, HashSet < String >> ();
        for (int i = 0; i < langs.length; i++) {
            FileResource dictionaryFile = new FileResource("dictionaries/"+langs[i]);
            HashSet < String > dictionary = readDictionary(dictionaryFile);
            allLangs.put(langs[i], dictionary);
            System.out.println("done reading dictionary: "+langs[i]);
        }
        return breakForAllLangs(input, allLangs);
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
        char mostCommonChar = mostCommonCharIn(dictionary);
        for (int i = 1; i <= 100; i++) {
            int[] key = tryKeyLength(input, i, mostCommonChar);
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

    public char mostCommonCharIn(HashSet < String > dictionary) {
        HashMap < Character, Integer > countChars = new HashMap < Character, Integer > ();
        for (String word: dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char lowerChar = Character.toLowerCase(word.charAt(i));
                if (!countChars.containsKey(lowerChar)) {
                    countChars.put(lowerChar, 1);
                } else {
                    countChars.put(lowerChar, countChars.get(lowerChar) + 1);
                }
            }
        }
        char finalChar = 'a';
        int maxCount = 0;
        for (char ch: countChars.keySet()) {
            if (countChars.get(ch) > maxCount) {
                maxCount = countChars.get(ch);
                finalChar = ch;
            }
        }
        System.out.println("most common char in dictionary is : "+finalChar);
        return finalChar;
    }

    public String breakForAllLangs(String input, HashMap < String, HashSet < String > > languages) {
        int maxCount = 0;
        String finalOutput = "";
        for (String lang: languages.keySet()) {
            System.out.println("processing for : "+lang);
            HashSet < String > dictionary = languages.get(lang);
            String output = breakForLanguage(input, dictionary);
            int count = countWords(output, dictionary);
            System.out.println("words matched in this language is : "+count);
            if (count > maxCount) {
                maxCount = count;
                finalOutput = output;
            }
        }
        return finalOutput;
    }
}