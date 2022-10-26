package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String args[])  {

        //programme réécrit
        ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile("symptoms.txt");
        Map<String, Integer> symptoms = CountSymptoms.getCountMap(readFile.GetSymptoms());
        WriteSymptomDataToFile writeFile = new WriteSymptomDataToFile("result.out");
        writeFile.writeSymptoms(symptoms);


        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            String symptom = "number of "+entry.getKey()+" : "+entry.getValue();
            System.out.println(symptom);
        }


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