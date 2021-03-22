package Assignment_2_Words_in_Files;

import edu.duke.FileResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordsInFiles {
    private HashMap<String, ArrayList<String> > wordCount;

    public WordsInFiles(){
        wordCount = new HashMap<>();
    }

    public void addWordsFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\W+");
        while (sc.hasNext()){
            String word = sc.next();
            if(!wordCount.containsKey(word)){
                wordCount.put(word, new ArrayList<String>());
                ArrayList<String> temp = wordCount.get(word);
                temp.add(file.getName());
                wordCount.put(word, temp);
            }else{
                ArrayList<String> temp = wordCount.get(word);
                if(!temp.contains(file.getName())){
                    temp.add(file.getName());
                    wordCount.put(word, temp);
                }
            }
        }
    }

    public void buildWordFileMap() throws FileNotFoundException {
        wordCount.clear();
        for(int i=1;i<5;i++){
            File file = new File("brief"+i+".txt");
            addWordsFromFile(file);
        }
    }

    public int maxNumber(){
        int maxNumber = 0;
        for(String word : wordCount.keySet()){
            int len = wordCount.get(word).size();
            if(len > maxNumber){
                maxNumber = len;
            }
        }
        return maxNumber;
    }

    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> result = new ArrayList<>();
        for(String word : wordCount.keySet()){
            if(number == wordCount.get(word).size()){
                result.add(word);
            }
        }
        return result;
    }

    public void printFilesIn(String word){
        for (String fileName : wordCount.get(word)) {
            System.out.println(fileName);
        }
    }

    public void tester() throws FileNotFoundException {
        buildWordFileMap();
        System.out.println("maximum number of files any word is in : "+maxNumber());
        for (String word : wordCount.keySet()){
            ArrayList<String> wordsInNumFiles = wordsInNumFiles(wordCount.get(word).size());
            for(String fileName : wordsInNumFiles){
                System.out.println(fileName);
            }
        }
    }
}
