package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counts the number of symptoms from a list
 *
 */
public class CountSymptoms {

    /**
     * transform the list of symptoms to a treemap with count {symptom:count}
     *
     * @param symptoms the list of all symptoms from the file
     * @return a treemap like {symptom : count}
     */
    public static Map<String, Integer> getCountMap(List<String> symptoms){

        //on transforme la liste de symptoms en TreeMap pour avoir l'ordre alphabétique et supprimer les doublons
        Map<String, Integer> result = new TreeMap<>();

        for(String symptom:symptoms){
            Integer tmp = result.get(symptom);
            if(tmp == null){
                result.put(symptom, 1);
            }else {
                result.put(symptom, tmp+1);
            }

        }

        return result;
    }


}
