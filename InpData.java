package project_files;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InpData {
     Nodey head = null;
     Nodey tail = null;
    Sorting sorting = new Sorting();
    Searching searching = new Searching();
    StackOperations stackOps = new StackOperations();
    QueueOperations queueOps = new QueueOperations();
    HashGateKeep H = new HashGateKeep(100);
    FileOperations fileOps = new FileOperations(head);
    
    public Nodey DataEntry(double marks, long ht, String name) {
        Nodey newNode = new Nodey(marks, ht, name);
        if (head == null) {
            head= tail = newNode;
        } else {
            tail.link = newNode;
        }
        fileOps.saveToFile(marks, ht, name);
        return newNode;
    }
    
    public void loadFileToLL() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\SAI RAKESH\\Desktop\\student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                double marks = Double.parseDouble(data[0]);
                long ht = Long.parseLong(data[1]);
                String name = data[2];
                
                Nodey newNode = new Nodey(marks, ht, name);
                if (head == null) {
                    head = newNode;
                } else {
                    Nodey temp = head;
                    while (temp.link != null) {
                        temp = temp.link;
                    }
                    temp.link = newNode;
                }
                H.Insert(newNode);
            }
            System.out.println("Data loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
    
    public int Count() {
        Nodey temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        return count;
    }
    
    public void Tranfer(Nodey[] ar) {
        Nodey temp = head;
        for (int i = 0; i < ar.length && temp != null; i++) {
            ar[i] = temp;
            temp = temp.link;
        }
    }
    
    public void DataEnter(InpData d) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Entries: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + 
                             " Order= Marks Hall Ticket Name");
            double marks = sc.nextDouble();
            long ht = sc.nextLong();
            String name = sc.next();
            if (stackOps.HTcheck(ht)) {
                if (H.IsExist(ht)) {
                    System.out.println("Already Exists! Try again.");
                    i--;
                    continue;
                }
                Nodey student = d.DataEntry(marks, ht, name);
                H.Insert(student);
            } else {
                System.out.println("Invalid Hall Ticket! Must start with " + stackOps.stp);
                i--;
            }
        }
    }
    
    public void SearchAndDisplay(long key) {
        if (isEmpty()) {
            System.out.println("ENTER DATA FIRST!!");
            return;
        }
        
        int count = Count();
        Nodey[] ar = new Nodey[count];
        Nodey[] temp = new Nodey[ar.length];
        Tranfer(ar);
        
        // Display BEFORE sorting
        System.out.println("\n--- Student Records (Before Sorting by Hall Ticket) ---");
        sorting.Display(ar);
        
        // Sort by Hall Ticket
        sorting.Sort(ar, temp, 0, ar.length - 1);
        
        // Display AFTER sorting
        System.out.println("\n--- Student Records (After Sorting by Hall Ticket) ---");
        sorting.Display(ar);
        
        // Now search
        System.out.println("\n--- Search Result ---");
        if (stackOps.HTcheck(key)) {
            int mid = searching.BinarySearch(ar, key);
            if (mid != -1) {
                System.out.println("   Hall Ticket: " + ar[mid].Ht);
                System.out.println("   Name: " + ar[mid].name);
                System.out.println("   Marks: " + ar[mid].marks);
            } else {
                System.out.println("Hall Ticket " + key + " NOT FOUND in records!");
            }
        } else {
            System.out.println("✗ Invalid Hall Ticket format! Must start with " + stackOps.stp);
        }
    }
    
    public void TopRankers() {
        queueOps.TopRankers(head);
    }
    
    public void otherRank() {
        queueOps.otherRank(Count());
    }
    
    public void printFileData() {
        fileOps.printFileData();
    }
    
    public void clearFile() {
        fileOps.clearFile();
        head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}