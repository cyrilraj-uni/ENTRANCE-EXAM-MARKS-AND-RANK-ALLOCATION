package project_files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    private Nodey head;
    
    public FileOperations(Nodey head) {
        this.head = head;
    }
    
    public void saveToFile(double marks, long ht, String name) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\SAI RAKESH\\Desktop\\student.txt", true))) {
            writer.write(marks + "," + ht + "," + name);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    
    public void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\SAI RAKESH\\Desktop\\student.txt"))) {
            writer.write("");
            System.out.println("File cleared successfully.");
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }
    
    public void printFileData() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\SAI RAKESH\\Desktop\\student.txt"))) {
            String line;
            System.out.println("\n--- Student Data From File ---");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Marks: " + data[0] + " HT: " + data[1] + " Name: " + data[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}