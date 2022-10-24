package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counts the number of symptoms from a list
 *
 */
public class CountSymptoms {


    /**
     * counts an individual symptom
     *
     * @param symptom the symptom we want to count
     * @param symptoms the list of all symptoms from the file
     * @return the number of occurrences of a symptom in the file
     */
    public static int getCount(String symptom, ArrayList<String> symptoms){
        int count = 0;

        for(String symp : symptoms){
            if(symp.equals(symptom)){
                count++;
            }
        }

        return count;
    }

    /**
     * transform the list of symptoms to a treemap {symptom:number}
     *
     * @param symptoms the list of all symptoms from the file
     * @return a treemap like {symptom : number}
     */
    public static Map<String, Integer> getCountMap(ArrayList<String> symptoms){
        //on converti la liste en HashSet pour supprimer les doublons
        ArrayList<String> symptomsWithNoDuplicates = new ArrayList<>(new HashSet<>(symptoms));
        //on transforme le resultat en TreeMap pour avoir l'ordre alphabétique
        Map<String, Integer> result = new TreeMap<>();

        for(String symptom:symptomsWithNoDuplicates){
            result.put(symptom, getCount(symptom,symptoms));
        }

        return result;
    }


}
