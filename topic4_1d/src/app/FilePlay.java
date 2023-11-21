package app;

import java.io.*;

public class FilePlay {

    public static void main(String[] args) {
        try {
            copyFile("InUsers.txt", "OutUsers.txt");
            System.out.println("Copy operation successful.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: I/O Error - " + e.getMessage());
        }
    }

    private static void copyFile(String inputFilename, String outputFilename) throws FileNotFoundException, IOException {
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