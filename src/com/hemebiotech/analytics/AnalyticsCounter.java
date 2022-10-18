package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String args[])  {

        //programme réécrit
        ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile("symptoms.txt");
        ArrayList<String> symptoms = readFile.GetSymptoms();
        HashMap<String, Integer> list = CountSymptoms.getCountMap(symptoms);
        WriteSymptomDataToFile writeFile = new WriteSymptomDataToFile("result.out");

        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            String text = "number of "+entry.getKey()+" : "+entry.getValue();
            System.out.println(text);
            writeFile.writeSymptom(text);
        }

        writeFile.closeWriter();

        /*
        //Programme d'Alex corrigé
        try{


        // first get input
        BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
        String line = reader.readLine();


        while (line != null) {

            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headacheCount++;
            }
            else if (line.equals("rash")) {
                rashCount++;
            }
            else if (line.equals("dilated pupils")) {
                pupilCount++;
            }

            line = reader.readLine();	// get another symptom

        }

        reader.close();
        System.out.println("number of headaches: " + headacheCount);

        // next generate output
        FileWriter writer = new FileWriter ("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dilated pupils: " + pupilCount + "\n");
        writer.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

        */
    }
}