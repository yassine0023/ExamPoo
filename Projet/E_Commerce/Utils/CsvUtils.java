package E_Commerce.Utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtils {

    public static void main(String [] args ){
        String CSV_FILE_PATH = "Application/utils/testCSV.csv";
        CsvUtils.writeCSV(Arrays.asList("1", "John Doe", "30") , CSV_FILE_PATH);
        CsvUtils.writeCSV(Arrays.asList("1", "Matt Damon", "21") , CSV_FILE_PATH);
        CsvUtils.writeCSV(Arrays.asList("1", "David Bowie", "43") , CSV_FILE_PATH);
        CsvUtils.writeCSV(Arrays.asList("4", "Jimi Hendrix", "19") , CSV_FILE_PATH);
        CsvUtils.writeCSV(Arrays.asList("1", "Thom York", "24") , CSV_FILE_PATH);
        String[] data = {"12222", "John Doe", "30"};
        CsvUtils.appendToCSV(data , CSV_FILE_PATH);
        CsvUtils.removeLineFromCSV(4, CSV_FILE_PATH);
    }

    public static void writeCSV(List<String> data, String CSV_FILE_PATH) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            StringBuilder line = new StringBuilder();
            for (String field : data) {
                line.append(field).append(",");
            }
            line.deleteCharAt(line.length() - 1); // Remove trailing comma
            writer.write(line.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<List<String>> readCSV(String CSV_FILE_PATH) {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(Arrays.asList(fields));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public  static void appendToCSV(String[] data , String CSV_FILE_PATH) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            StringBuilder line = new StringBuilder();
            // Create a CSV line by concatenating fields with commas
            for (String field : data) {
                line.append(field).append(",");
            }
            // Remove the trailing comma and write to the file
            line.deleteCharAt(line.length() - 1);
            writer.write(line.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeLineFromCSV(int lineToRemove , String CSV_FILE_PATH) {
        if (lineToRemove >=0){
            try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {
                String line;
                int lineNumber = 1;
                // Read each line and write to a temporary file, excluding the line to be removed
                while ((line = reader.readLine()) != null) {
                    if (lineNumber != lineToRemove) {
                        writer.write(line);
                        writer.newLine();
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Rename the temporary file to the original file name
            try {
                if (new java.io.File("temp.csv").renameTo(new java.io.File(CSV_FILE_PATH))) {
                    System.out.println("Line removed successfully.");
                } else {
                    System.out.println("Error in renaming the file.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int find_index_line(List<String>data , String CSV_FILE_PATH){
        List<List<String>> csv_content = CsvUtils.readCSV(CSV_FILE_PATH);
        boolean test ;
        for (int index_line = 0 ; index_line < csv_content.size()  ; index_line++){
            test = true ;
            for (int i = 0 ; i < csv_content.get(index_line).size() && i< data.size() ; i ++ ){
                if (!csv_content.get(index_line).get(i).equals(data.get(i))){
                    test = false ;
                    break ;
                }
            }
            if (test == true ){
                return index_line;
            }
        }
        return -1 ;
    }
}