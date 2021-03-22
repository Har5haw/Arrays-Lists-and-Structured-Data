package Assignment_1_Most_Frequent_Word;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        this.myWords = new ArrayList<String>();
        this.myFreqs = new ArrayList<Integer>();
    }

    public int findIndexOfMax(){
        int maxValue = 0;
        int maxIndex = 0;
        for(int i=0;i<myFreqs.size();i++){
            if(maxValue < myFreqs.get(i)){
                maxValue = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fileResource = new FileResource();
        for(String word : fileResource.words()){
            if(word.length() > 0){
                String lowerCaseWord = word.toLowerCase();
                int indexOfWord = myWords.indexOf(lowerCaseWord);
                if(indexOfWord == -1){
                    myWords.add(lowerCaseWord);
                    myFreqs.add(1);
                }else{
                    myFreqs.set(indexOfWord, myFreqs.get(indexOfWord)+1);
                }
            }
        }
    }

    public void tester(){
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        for (int i=0;i<myFreqs.size();i++){
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
        System.out.println("The word that occurs most often and its count are: "+myWords.get(findIndexOfMax())+" "+myFreqs.get(findIndexOfMax()));
    }
}
