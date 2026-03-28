package project_files;
public class Searching {
    
    public int BinarySearch(Nodey[] ar, long ht) {
        int low = 0, high = ar.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ar[mid].Ht == ht) {
                return mid;
            }
            if (ar[mid].Ht < ht) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}