package Assignment_1_One_Key;

import Assignment_1_Word_lengths.WordLengths;
import edu.duke.FileResource;

import java.util.Arrays;

public class TestCaesarCipher {
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

    public static int indexOfMax(int[] arr){
        int maxValue = 0;
        int indexOfMax = 0;
        for(int i=0;i<arr.length;i++){
            if(maxValue < arr[i]){
                maxValue = arr[i];
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    public void simpleTests(){
        FileResource fileResource = new FileResource();
        CaesarCipher caesarCipher = new CaesarCipher(18);
        String encrypted = caesarCipher.encrypt(fileResource.asString());
        System.out.println("encrypted string : "+encrypted);
        String decrypt = caesarCipher.decrypt(encrypted);
        System.out.println("decrypted string with key : "+decrypt);
        decrypt = breakCaesarCipher(encrypted);
        System.out.println("decrypted string without key : "+decrypt);
    }

    public String breakCaesarCipher(String input){
        int countArray[] = countLetters(input);
        int indexOfHighFrequent = indexOfMax(countArray);
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char mostRepeatedChar = alphabets.charAt(indexOfHighFrequent);
        int diffMostRepeated = (int)mostRepeatedChar - (int)'e';
        if(diffMostRepeated < 0){
            diffMostRepeated = 26 + diffMostRepeated;
        }
        int key = diffMostRepeated;
        CaesarCipher caesarCipher = new CaesarCipher(key);
        return caesarCipher.decrypt(input);
    }
}
