/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Robyn
 */
public class ModifyFile {
    
    //different objects to read and write files
    FileWriter fw = null;
    BufferedWriter bw = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    public ModifyFile(){
        
    }
    
    public void reduceTo5(File file, String name) { //file object needs to be named like the actual txt
                
        int word_count = 0; //keeps the amount of words that have been written into the new file
        
        try {
            fw = new FileWriter("src/files/"+name+"_5.txt");
            //gets the name of the file plus _5 for the modified file
            bw = new BufferedWriter(fw);
            
            fr = new FileReader("src/files/"+name+".txt");
            //takes name parameter to find the file
            br = new BufferedReader(fr);
            
            String reading = "";
            
            System.out.println("Reading file "+name+"...");
            
            if (br.ready()){
                do {
                    reading = br.readLine();
                    if (reading != null) { //avoids NullPointerException
                        if (reading.length() == 5) {
                            reading = reading.toUpperCase(); //upper case is convenient for wordle
                            fw.write(reading+"\n");
                            //writes a 5 letter word into the new file line by line
                            word_count++; 
                        }
                    }
                } while (reading != null); //ends when it reaches the end of the document
                fr.close();
                fw.close();
                
                System.out.println("File with just 5 letter words created.");
                System.out.println("Word amount: "+word_count+"\n"); //shows amount of words saved
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File specified doesn't exist. Error: "+ex);
            ex.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("Error: "+ex);
            ex.printStackTrace();
        }
    }
    
    public void removeTildes(File file, String name) {
        
        int word_count = 0; //keeps the amount of words that have been written into the new file
        String tildes = "ÁáÉéÍíÓóÚúÜü"; //does not remove eñes
        String noTildes = "AaEeIiOoUuUu"; //characters that will replace the accented ones
        
        try {
            fw = new FileWriter("src/files/"+name+"_noTildes.txt");
            //gets the name of the file plus _noTildes for the modified file
            bw = new BufferedWriter(fw);
            
            fr = new FileReader("src/files/"+name+".txt");
            //takes name parameter to find the file
            br = new BufferedReader(fr);
            
            String reading = "";
            
            System.out.println("Reading file "+name+"...");
            
            if (br.ready()){
                do {
                    reading = br.readLine();
                    if (reading != null) { //avoids NullPointerException
                        //checks if the reading string has any tildes
                        if (reading.matches(".*["+tildes+"].*")) {
                            for (int i=0; i<tildes.length(); i++) {
                                //replaces accents in word
                                reading = reading.replace(tildes.charAt(i), noTildes.charAt(i));
                            }
                        }
                        fw.write(reading+"\n");
                        //writes a 5 letter word into the new file line by line
                        word_count++; 
                    }
                } while (reading != null); //ends when it reaches the end of the document
                fr.close();
                fw.close();
                
                System.out.println("File with just 5 letter words and no tildes created.");
                System.out.println("Word amount: "+word_count+"\n"); //shows amount of words saved
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File specified doesn't exist. Error: "+ex);
            ex.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("Error: "+ex);
            ex.printStackTrace();
        }
    }
    
}
