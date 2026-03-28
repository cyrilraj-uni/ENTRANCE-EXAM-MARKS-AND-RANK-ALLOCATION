package project_files;
public class Sorting {
    
    public void Sort(Nodey[] ar, Nodey[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            Sort(ar, temp, low, mid);
            Sort(ar, temp, mid + 1, high);
            merge(ar, temp, low, mid, high);
        }
    }
    
    private void merge(Nodey[] arr, Nodey[] temp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        
        while (i <= mid && j <= high) {
            if (arr[i].Ht <= arr[j].Ht) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        
        for (int p = low; p <= high; p++) {
            arr[p] = temp[p];
        }
    }
    
    public void Display(Nodey[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println("Student " + (i + 1) + ": HT: " + ar[i].Ht + 
                             " Name: " + ar[i].name + " Marks: " + ar[i].marks);
        }
    }
}
