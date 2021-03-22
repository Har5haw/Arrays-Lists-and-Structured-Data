package UnKnownLanguageAndUnknownKeyLength;

import java.util.Arrays;

public class CaesarCrack {
    char commonChar;

    public CaesarCrack(char commonChar){
        this.commonChar = commonChar;
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

    public int getKey(String input){

        int countArray[] = countLetters(input);
        int indexOfHighFrequent = indexOfMax(countArray);
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char mostRepeatedChar = alphabets.charAt(indexOfHighFrequent);
        int diffMostRepeated = mostRepeatedChar - commonChar;
        if(diffMostRepeated < 0){
            diffMostRepeated = 26 + diffMostRepeated;
        }
        return diffMostRepeated;
    }
}
