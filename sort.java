import java.util.Scanner;
import java.lang.Math;

public class sort{

    /*public static void heapsort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } */
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  
    /* A utility function to print array of size n */
    public static void printArray(int arr[],int dol) {
        
        int stev = 1;
        for (int i=0; i<dol; ++i) {
            if(Math.pow(2,stev)-1 == i){
                System.out.print("| ");
                stev++;
            }
            System.out.print(arr[i]+" "); 
        }
        System.out.println(); 
    } 

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] tabela = new int[a];
        for(int i=0;i<a;i++){
            tabela[i]=sc.nextInt();
        }
        //System.out.println("************");

        //heapify(tabela,a,0);
        for(int i=a-1;i>=0;i--){
            heapify(tabela,a,i);
            //printArray(tabela);
        }
        //System.out.println("*konec*");
        printArray(tabela,a);
        /*int b=a;
        for (int j=0;j<a-1;j++){
            b--;
            System.out.println("zadnji el: "+tabela[b]);
            tabela[0]= tabela[b];
            
            heapify(tabela,b-1,0);
            printArray(tabela);
        }*/
        for (int i=a-1; i>=0; i--) {
            // Move current root to end 
            int temp = tabela[0]; 
            tabela[0] = tabela[i]; 
            tabela[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(tabela, i, 0); 
            printArray(tabela,i);
        } 






        sc.close();
    }
}