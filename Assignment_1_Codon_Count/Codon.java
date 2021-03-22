package Assignment_1_Codon_Count;

import edu.duke.FileResource;

import java.util.HashMap;

public class Codon {
    private HashMap<String, Integer> codonCount;
    public Codon(){
        codonCount = new HashMap<>();
    }
    public void buildCodonMap(int start, String dna){
        codonCount.clear();
        for(int i=start; i<dna.length()-2;i+=3){
            String codon = dna.substring(i, i+3);
            if(!codonCount.containsKey(codon)){
                codonCount.put(codon, 1);
            }else{
                codonCount.put(codon, codonCount.get(codon)+1);
            }
        }
    }

    public String getMostCommonCodon(){
        int maxCodonCount = 0;
        String maxCodon = "";
        for(String codon : codonCount.keySet()){
            if(maxCodonCount < codonCount.get(codon)){
                maxCodonCount = codonCount.get(codon);
                maxCodon = codon;
            }
        }
        return maxCodon;
    }

    public void printCodonCounts(int start, int end){
        for(String codon : codonCount.keySet()){
            if(start <= codonCount.get(codon) && end >= codonCount.get(codon)){
                System.out.println(codon + " " + codonCount.get(codon));
            }
        }
    }

    public void tester(){
        FileResource fileResource = new FileResource();
        String input = fileResource.asString();
        input = input.toUpperCase();
        buildCodonMap(0, input);
        System.out.println("most common codon is : "+getMostCommonCodon());
        printCodonCounts(0, 5);
        buildCodonMap(1, input);
        System.out.println("most common codon is : "+getMostCommonCodon());
        printCodonCounts(0, 5);
        buildCodonMap(2, input);
        System.out.println("most common codon is : "+getMostCommonCodon());
        printCodonCounts(0, 5);
    }
}
