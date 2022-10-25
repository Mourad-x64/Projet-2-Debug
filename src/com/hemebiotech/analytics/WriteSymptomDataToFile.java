package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Write symptoms to a file
 *
 */
public class WriteSymptomDataToFile {
    private String fileName;
    private FileWriter writer;

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

            this.writer = new FileWriter (fileName);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param symptom the text to write to the file
     */
    public void writeSymptom(String symptom){
        try{
            writer.write(symptom + "\n");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    // rajouter une fonction write

    /**
     *
     * close the writer
     */
    public void closeWriter(){
        try{
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
