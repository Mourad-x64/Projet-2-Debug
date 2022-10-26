package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * Write symptoms to a file
 *
 */
public class WriteSymptomDataToFile {
    private String fileName;

    /**
     *
     * @param fileName name of the file to write in
     */
    public WriteSymptomDataToFile(String fileName) {
        this.fileName = fileName;
        try{
            File myFile = new File(fileName);

            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Writes the symptoms to the file
     *
     * @param symptoms the symptom map with count
     */
    public void writeSymptoms(Map<String, Integer> symptoms){
        try{
            FileWriter writer = new FileWriter (fileName);
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String symptom = "number of "+entry.getKey()+" : "+entry.getValue();
                writer.write(symptom + "\n");
            }

            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
