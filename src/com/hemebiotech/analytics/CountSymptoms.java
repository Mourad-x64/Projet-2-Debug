package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
     * transform the list of symptoms to a hashmap {symptom:number}
     *
     * @param symptoms the list of all symptoms from the file
     * @return a hashmap like {symptom : number}
     */
    public static HashMap<String, Integer> getCountMap(ArrayList<String> symptoms){

        ArrayList<String> symptomsWithNoDuplicates = new ArrayList<>(new HashSet<>(symptoms));
        HashMap<String, Integer> result = new HashMap<>();

        for(String symptom:symptomsWithNoDuplicates){
            result.put(symptom, getCount(symptom,symptoms));
        }

        return result;

    }





}
