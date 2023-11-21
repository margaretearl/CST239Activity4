package app;

import java.io.*;

public class FilePlay {

    public static void main(String[] args) {
        
        int result = copyFile("InUsers.txt", "OutUsers.txt");

        switch (result) {
            case 0:
                System.out.println("Copy operation successful.");
                break;
            case -1:
                System.out.println("Error: File Not Found");
                break;
            case -2:
                System.out.println("Error: I/O Error");
                break;
            default:
                System.out.println("Unknown error code: " + result);
        }
    }
    private static int copyFile(String inputFilename, String outputFilename) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            
            bufferedReader = new BufferedReader(new FileReader(inputFilename));
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] tokens = line.split("\\|");

               
                String outputLine = String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]);
                bufferedWriter.write(outputLine);
            }

            System.out.println("File copied successfully.");

            return 0;

        } catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found - " + e.getMessage());
            return -1;

        } catch (IOException e) {
            System.out.println("Error: I/O Error - " + e.getMessage());
            return -2;

        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        	} 
        }
    }
