package project_files;
import java.util.Scanner;

public class KLUentryExamm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InpData d = new InpData();
        d.loadFileToLL();
        int choice;
        
        do {
            System.out.println("1.Enter Data\n2.Search by Hall Ticket\n3.Display toppers\n4.Display Rest of Ranks\n5.Print the data in file\n6.Delete Data in file\"\n7.Exit\n");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    d.DataEnter(d);
                    break;
                case 2:
                    System.out.print("Enter Hall ticket: ");
                    long key = sc.nextLong();
                    d.SearchAndDisplay(key);
                    break;
                case 3:
                    d.TopRankers();
                    break;
                case 4:
                    d.otherRank();
                    break;
                case 5:
                    d.printFileData();
                    break;
                case 6:
                    d.clearFile();
                    break;
                case 7:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("invalid choice");
            }
        } while (choice != 7);
    }
}