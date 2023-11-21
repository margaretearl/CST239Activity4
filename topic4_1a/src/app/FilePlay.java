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
        
        int c = 0;
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            
            fileReader = new FileReader(inputFilename);
            fileWriter = new FileWriter(outputFilename);

            
            while ((c = fileReader.read()) != -1) {
                
                fileWriter.write(c);
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
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
} 