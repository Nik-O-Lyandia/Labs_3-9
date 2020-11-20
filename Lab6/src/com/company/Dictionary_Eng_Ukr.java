package com.company;

import java.util.HashMap;
import java.util.Map;

public class Dictionary_Eng_Ukr {
    private HashMap<String,String> Dictionary;

    public Dictionary_Eng_Ukr() {
        this.Dictionary = new HashMap<>();
    }

    public Dictionary_Eng_Ukr(HashMap<String,String> preReadyMap) {
        this.Dictionary = preReadyMap;
    }

    public void addToDictionary(String engWord, String ukrWord) {
        Dictionary.put(engWord, ukrWord);
    }

    public String getTranslation(String str) {
        String[] strs = str.split(" ");
        String finalStr = "";
        for(int i = 0; i < strs.length; i++) {
            if(Dictionary.get(strs[i]) != null) {
                finalStr += Dictionary.get(strs[i]);
            }
            else {
                finalStr += strs[i];
            }
            finalStr += " ";
        }
        return finalStr;
    }
}
