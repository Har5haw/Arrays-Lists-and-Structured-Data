package Assignment_1_Word_lengths;

import edu.duke.FileResource;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WordLengths {
    public void countWordLengths(FileResource fileResource, int[] arr){
        for(String word : fileResource.words()){
            if(word.length() > 0) {
                if (Character.isLetter(word.charAt(word.length() - 1))) {
                    arr[word.length()]++;
                } else {
                    arr[word.length() - 1]++;
                }
            }
        }
    }

    public int indexOfMax(int[] arr){
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

    public void testCountWordLengths(){
        FileResource fileResource = new FileResource();
        int arr[] = new int[100];
        Arrays.fill(arr, 0);
        countWordLengths(fileResource, arr);
        System.out.println(indexOfMax(arr));
    }
}
