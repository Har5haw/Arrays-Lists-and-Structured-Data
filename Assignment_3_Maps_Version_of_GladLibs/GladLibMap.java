package Assignment_3_Maps_Version_of_GladLibs;

import java.util.ArrayList;
import java.util.HashMap;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> categoryList;

    public GladLibMap(){
        categoryList.put("adjectiveList", new ArrayList<>());
        categoryList.put("nounList", new ArrayList<>());
        categoryList.put("colorList", new ArrayList<>());
        categoryList.put("countryList", new ArrayList<>());
        categoryList.put("nameList", new ArrayList<>());
        categoryList.put("animalList", new ArrayList<>());
        categoryList.put("timeList", new ArrayList<>());
        categoryList.put("verbList", new ArrayList<>());
        categoryList.put("fruitList", new ArrayList<>());
    }
}
