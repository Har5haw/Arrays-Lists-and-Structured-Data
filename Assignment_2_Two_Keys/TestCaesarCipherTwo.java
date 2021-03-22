package Assignment_2_Two_Keys;

import Assignment_2_CaesarCipher.CaesarCipher;
import Assignment_2_Caesar_Cipher_Two_Keys_Decrypt.CaesarBreaker;
import edu.duke.FileResource;

import java.util.Arrays;

public class TestCaesarCipherTwo {
    public String halfOfString(String input, int start){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=start; i<input.length();i+=2){
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

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
        CaesarCipherTwo caesarCipherTwo = new CaesarCipherTwo(17, 3);
        String encrypt = caesarCipherTwo.encrypt(fileResource.asString());
        System.out.println("encrypted test is : "+encrypt);
        String decrypt = caesarCipherTwo.decrypt(encrypt);
        System.out.println("decrypted text with keys is"+decrypt);
        decrypt = breakCaesarCipher(encrypt);
        System.out.println("decrypted text without keys is"+decrypt);
    }

    public String breakCaesarCipher(String input){
        String firstHalf = halfOfString(input, 0);
        String secondHalf = halfOfString(input, 1);
        CaesarBreaker caesarBreaker = new CaesarBreaker();
        int key1 = caesarBreaker.getKey(firstHalf);
        int key2 = caesarBreaker.getKey(secondHalf);
        System.out.println("key 1 : "+key1);
        System.out.println("key 2 : "+key2);
        String decrypted = CaesarCipher.encryptTwoKeys(input, 26-key1, 26-key2);
        return decrypted;
    }
}
