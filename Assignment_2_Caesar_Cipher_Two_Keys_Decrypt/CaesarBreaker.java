package Assignment_2_Caesar_Cipher_Two_Keys_Decrypt;

import Assignment_1_Word_lengths.WordLengths;
import Assignment_2_CaesarCipher.CaesarCipher;

import java.util.Arrays;

public class CaesarBreaker {
    public int[] countLetters(String s){
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int countArray[] = new int[27];
        Arrays.fill(countArray, 0);
        for(char ch : s.toCharArray()){
            int position = alphabets.indexOf(Character.toLowerCase(ch));
            if(position != -1) {
                countArray[position]++;
            }
        }
        return countArray;
    }

    public int getKey(String input) {
        int countArray[] = countLetters(input);
        int indexOfHighFrequent = WordLengths.indexOfMax(countArray);
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char mostRepeatedChar = alphabets.charAt(indexOfHighFrequent);
        int diffMostRepeated = (int)mostRepeatedChar - (int)'e';
        if(diffMostRepeated < 0){
            diffMostRepeated = 26 + diffMostRepeated;
        }
        return diffMostRepeated;
    }

    public String halfOfString(String input, int start){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=start; i<input.length();i+=2){
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String decryptTwoKeys(String encrypted){
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        System.out.println("key 1 : "+key1);
        System.out.println("key 2 : "+key2);
        String decrypted = CaesarCipher.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        return decrypted;
    }
}
