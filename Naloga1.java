import java.util.Scanner;

public class Naloga1 {

    public static class Global{
        public static int gleda=0;
        public static int zamenjave;
    }




    public static void bubble(int[] tabela, int smer, int trco){
        int n = tabela.length; 
        
        //System.out.println("smer= " +smer+"trco= "+trco);
        if(smer==0 && trco == 1){
            System.out.print("| ");
            for(int j=0;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();
            for (int i = 0; i < n-1; i++) {
                
                for (int j = n-1; j >i; j--) {
                    //System.out.println(tabela[j]+" > "+tabela[j-1]);
                    if (tabela[j] > tabela[j-1]) 
                    { 
                        // swap arr[j+1] and arr[i] 
                        int temp = tabela[j]; 
                        tabela[j] = tabela[j-1]; 
                        tabela[j-1] = temp; 
                    } 
                }
                for(int j=0;j<n;j++){
                    System.out.print(tabela[j]+" ");
                    if(j==i){
                        System.out.print("| ");
                    }
                }
                System.out.println();
            }
        } else if(smer==1&& trco==1){
            System.out.print("| ");
            for(int j=0;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();
            for (int i = 0; i < n-1; i++) {
                
                for (int j = n-1; j >i; j--) {
                    //System.out.println(tabela[j]+" > "+tabela[j-1]);
                    if (tabela[j] < tabela[j-1]) 
                    { 
                        // swap arr[j+1] and arr[i] 
                        int temp = tabela[j]; 
                        tabela[j] = tabela[j-1]; 
                        tabela[j-1] = temp; 
                    } 
                }
                for(int j=0;j<n;j++){
                    System.out.print(tabela[j]+" ");
                    if(j==i){
                        System.out.print("| ");
                    }
                }
                System.out.println();
            }
        } else if(trco==0&&smer==0){
            int vsota=0;
            for(int i =1;i<n;i++){
                vsota += i;
            }
            int zamenjave=0;
            for (int i = 0; i < n-1; i++) {
                
                for (int j = n-1; j >i; j--) {
                    //System.out.println(tabela[j]+" > "+tabela[j-1]);
                    if (tabela[j] > tabela[j-1]) 
                    { 
                        zamenjave++;
                        // swap arr[j+1] and arr[i] 
                        int temp = tabela[j]; 
                        tabela[j] = tabela[j-1]; 
                        tabela[j-1] = temp; 
                    } 
                }
                
            }
            System.out.println(vsota+" "+zamenjave*3);
            System.out.println(vsota+" 0");
            zamenjave=0;
            for (int i = 0; i < n-1; i++) {
                
                for (int j = n-1; j >i; j--) {
                    //System.out.println(tabela[j]+" > "+tabela[j-1]);
                    if (tabela[j] < tabela[j-1]) 
                    { 
                        zamenjave++;
                        // swap arr[j+1] and arr[i] 
                        int temp = tabela[j]; 
                        tabela[j] = tabela[j-1]; 
                        tabela[j-1] = temp; 
                    } 
                }
                
            }
            System.out.println(vsota+" "+zamenjave*3);
        } else if (trco==0&& smer==1){
            int vsota=0;
            for(int i =1;i<n;i++){
                vsota += i;
            }
            int zamenjave=0;
            for (int i = 0; i < n-1; i++) {
                
                for (int j = n-1; j >i; j--) {
                    //System.out.println(tabela[j]+" > "+tabela[j-1]);
                    if (tabela[j] < tabela[j-1]) 
                    { 
                        zamenjave++;
                        // swap arr[j+1] and arr[i] 
                        int temp = tabela[j]; 
                        tabela[j] = tabela[j-1]; 
                        tabela[j-1] = temp; 
                    } 
                }
                
            }
            System.out.println(vsota+" "+zamenjave*3);
            System.out.println(vsota+" 0");
            zamenjave=0;
            for (int i = 0; i < n-1; i++) {
                
                for (int j = n-1; j >i; j--) {
                    //System.out.println(tabela[j]+" > "+tabela[j-1]);
                    if (tabela[j] > tabela[j-1]) 
                    { 
                        zamenjave++;
                        // swap arr[j+1] and arr[i] 
                        int temp = tabela[j]; 
                        tabela[j] = tabela[j-1]; 
                        tabela[j-1] = temp; 
                    } 
                }
                
            }
            System.out.print(vsota+" "+zamenjave*3);
        }
    }

    public static void selection(int[] tabela,int smer, int trco){
        int n = tabela.length; 

        if(smer==1 && trco==1){
            System.out.print("| ");
            for(int j=0;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();
            // One by one move boundary of unsorted subarray 
            for (int i = 0; i < n-1; i++) { 
                // Find the minimum element in unsorted array 
                int min_idx = i; 
                for (int j = i+1; j < n; j++) {
                    if (tabela[j] < tabela[min_idx]){ 
                        min_idx = j; 
                    }
                }
                // Swap the found minimum element with the first 
                // element 
                int temp = tabela[min_idx]; 
                tabela[min_idx] = tabela[i]; 
                tabela[i] = temp;
                for(int j=0;j<n;j++){
                    System.out.print(tabela[j]+" ");
                    if(j==i){
                        System.out.print("| ");
                    }
                }
                System.out.println(); 
            }
        } else if (smer==0 && trco==1){
            System.out.print("| ");
            for(int j=0;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();
            // One by one move boundary of unsorted subarray 
            for (int i = 0; i < n-1; i++) { 
                // Find the minimum element in unsorted array 
                int min_idx = i; 
                for (int j = i+1; j < n; j++) {
                    if (tabela[j] > tabela[min_idx]){ 
                        min_idx = j; 
                    }
                }
                // Swap the found minimum element with the first 
                // element 
                int temp = tabela[min_idx]; 
                tabela[min_idx] = tabela[i]; 
                tabela[i] = temp;
                for(int j=0;j<n;j++){
                    System.out.print(tabela[j]+" ");
                    if(j==i){
                        System.out.print("| ");
                    }
                }
                System.out.println(); 
            } 
        } else if(smer==1&&trco==0){
            int vsota=0;
            for(int i =1;i<n;i++){
                vsota += i;
            }
            int zamenjave=0;
            for (int i = 0; i < n-1; i++) { 
                // Find the minimum element in unsorted array 
                int min_idx = i; 
                for (int j = i+1; j < n; j++) {
                    if (tabela[j] < tabela[min_idx]){ 
                        min_idx = j; 
                        
                    }
                }
                // Swap the found minimum element with the first 
                // element 
                int temp = tabela[min_idx]; 
                tabela[min_idx] = tabela[i]; 
                tabela[i] = temp;
                zamenjave++;
            } 
            
            System.out.println(vsota+" "+zamenjave*3);
            System.out.println(vsota+" "+zamenjave*3);
            System.out.println(vsota+" "+zamenjave*3);
        } else if(smer==0&&trco==0){
            int vsota=0;
            for(int i =1;i<n;i++){
                vsota += i;
            }
            int zamenjave=0;
            for (int i = 0; i < n-1; i++) { 
                // Find the minimum element in unsorted array 
                int min_idx = i; 
                for (int j = i+1; j < n; j++) {
                    if (tabela[j] > tabela[min_idx]){ 
                        min_idx = j; 
                        
                    }
                }
                zamenjave++;
                // Swap the found minimum element with the first 
                // element 
                int temp = tabela[min_idx]; 
                tabela[min_idx] = tabela[i]; 
                tabela[i] = temp;
                
            } 
            
            System.out.println(vsota+" "+((zamenjave*3)));
            System.out.println(vsota+" "+((zamenjave*3)));
            System.out.println(vsota+" "+((zamenjave*3)));
        }
    }

    public static void insertion(int[] tabela, int smer, int trco){
        if(smer==1&&trco==1){
            int n = tabela.length; 
            System.out.print(tabela[0]+" ");
            System.out.print("| ");
            for(int j=1;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();
            for (int i = 1; i < n; ++i) { 
                int key = tabela[i]; 
                int j = i - 1; 
    
                while (j >= 0 && tabela[j] > key) { 
                    tabela[j + 1] = tabela[j]; 
                    j = j - 1; 
                } 
                tabela[j + 1] = key; 
                for(int m=0;m<n;m++){
                    System.out.print(tabela[m]+" ");
                    if(m==i){
                        System.out.print("| ");
                    }
                }
                System.out.println();
            } 
        } else if(smer==0&&trco==1){
            int n = tabela.length; 
            System.out.print(tabela[0]+" ");
            System.out.print("| ");
            for(int j=1;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();
            for (int i = 1; i < n; ++i) { 
                int key = tabela[i]; 
                int j = i - 1; 
    
                while (j >= 0 && tabela[j] < key) { 
                    tabela[j + 1] = tabela[j]; 
                    j = j - 1; 
                } 
                tabela[j + 1] = key; 
                for(int m=0;m<n;m++){
                    System.out.print(tabela[m]+" ");
                    if(m==i){
                        System.out.print("| ");
                    }
                }
                System.out.println();
            } 
        } else if(smer==1&&trco==0){
            int n=tabela.length;
            int zamenjave=0;
            int vsota=0;
            int temp;
            for (int i = 1; i < n; i++) { 
                
                for(int j=i;j>0;j--){
                    vsota++;
                    if(tabela[j]<tabela[j-1]){
                        temp=tabela[j];
                        tabela[j]=tabela[j-1];
                        tabela[j-1]=temp;
                        zamenjave++;
                    }
                    else break;
                }
                
                
            } 
            System.out.println(vsota+" "+((zamenjave*3)));
            vsota=0;
            zamenjave=0;
            for (int i = 1; i < n; i++) { 
                
                for(int j=i;j>0;j--){
                    vsota++;
                    if(tabela[j]<tabela[j-1]){
                        temp=tabela[j];
                        tabela[j]=tabela[j-1];
                        tabela[j-1]=temp;
                        zamenjave++;
                    }
                    else break;
                }
                
                
            } 
            System.out.println(vsota+" "+((zamenjave*3)));
            vsota=0;
            zamenjave=0;
            for (int i = 1; i < n; i++) { 
                
                for(int j=i;j>0;j--){
                    vsota++;
                    if(tabela[j]>tabela[j-1]){
                        temp=tabela[j];
                        tabela[j]=tabela[j-1];
                        tabela[j-1]=temp;
                        zamenjave++;
                    }
                    else break;
                }
                
                
            } 
            System.out.println(vsota+" "+((zamenjave*3)));
        } else if(smer==0&&trco==0){
            int n=tabela.length;
            int zamenjave=0;
            int vsota=0;
            int temp;
            for (int i = 1; i < n; i++) { 
                
                for(int j=i;j>0;j--){
                    vsota++;
                    if(tabela[j]>tabela[j-1]){
                        temp=tabela[j];
                        tabela[j]=tabela[j-1];
                        tabela[j-1]=temp;
                        zamenjave++;
                    }
                    else break;
                }
                
                
            } 
            System.out.println(vsota+" "+((zamenjave*3)));
            vsota=0;
            zamenjave=0;
            for (int i = 1; i < n; i++) { 
                
                for(int j=i;j>0;j--){
                    vsota++;
                    if(tabela[j]>tabela[j-1]){
                        temp=tabela[j];
                        tabela[j]=tabela[j-1];
                        tabela[j-1]=temp;
                        zamenjave++;
                    }
                    else break;
                }
                
                
            } 
            System.out.println(vsota+" "+((zamenjave*3)));
            vsota=0;
            zamenjave=0;
            for (int i = 1; i < n; i++) { 
                
                for(int j=i;j>0;j--){
                    vsota++;
                    if(tabela[j]<tabela[j-1]){
                        temp=tabela[j];
                        tabela[j]=tabela[j-1];
                        tabela[j-1]=temp;
                        zamenjave++;
                    }
                    else break;
                }
                
                
            } 
            System.out.println(vsota+" "+((zamenjave*3)));
        }
    }

    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
        //Global.gleda++;
        // If left child is larger than root 
        if(l<n){
            Global.gleda++;
        }
        if(r<n){
            Global.gleda++;
        }
        if (l < n && arr[l] > arr[largest]) {
            largest = l; 
            //Global.gleda++;
            //System.out.println("ja?");
        }
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r; 
            //Global.gleda++;
            //System.out.println("tudi?");
        }
        //System.out.println("gleda: "+Global.gleda);
        // If largest is not root 
        if (largest != i) 
        { 
            //Global.gleda++;
            Global.zamenjave++;
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 

    public static void heapifyd(int arr[], int n, int i) 
    { 
        int smallest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
        //Global.gleda++;
        //System.out.println("i: "+i);
        // If left child is larger than root 
        if(l<n){
            Global.gleda++;
        }
        if(r<n){
            Global.gleda++;
        }
        if (l < n && arr[l] < arr[smallest]) {
            smallest = l; 
            //Global.gleda++;
        }
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] < arr[smallest]) {
            smallest = r; 
            //Global.gleda++;
        }
  
        // If largest is not root 
        if (smallest != i) 
        { 
            //Global.gleda++;
            Global.zamenjave++;
            int swap = arr[i]; 
            arr[i] = arr[smallest]; 
            arr[smallest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapifyd(arr, n, smallest); 
        } 
    } 

    public static void printArrayHeap(int arr[],int dol) {
        
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

    public static void heapSort(int[] tabela,int smer,int trco){
        int a=tabela.length;
        Global.gleda=0;
        Global.zamenjave=0;
        if(smer==1&&trco==1){  
            for(int i=(a/2)-1;i>=0;i--){
                heapify(tabela,a,i);
                //printArray(tabela);
            }
            //System.out.println("*konec*");
            printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
    
                // call max heapify on the reduced heap 
                heapify(tabela, i, 0); 
                printArrayHeap(tabela,i);
            } 
        } else if(smer==0&&trco==1){
            for(int i=(a/2)-1;i>=0;i--){
                heapifyd(tabela,a,i);
                //printArrayHeap(tabela,a);
            }
            //System.out.println("*konec*");
            printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
    
                // call max heapify on the reduced heap 
                heapifyd(tabela, i, 0); 
                printArrayHeap(tabela,i);
            } 
        } else if(smer==1&&trco==0){
            

            for(int i=(a/2)-1;i>=0;i--){
                heapify(tabela,a,i);
                //printArray(tabela);
                //Global.gleda++;
            }
            //System.out.println("*konec*");
            //printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
                Global.zamenjave++;
                // call max heapify on the reduced heap 
                heapify(tabela, i, 0); 
                //printArrayHeap(tabela,i);
            } 
            System.out.println(Global.gleda+" "+3*(Global.zamenjave-1));
            Global.gleda=0;
            Global.zamenjave=0;
            for(int i=(a/2)-1;i>=0;i--){
                heapify(tabela,a,i);
                //printArray(tabela);
                //Global.gleda++;
            }
            //System.out.println("*konec*");
            //printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
                Global.zamenjave++;
                // call max heapify on the reduced heap 
                heapify(tabela, i, 0); 
                //printArrayHeap(tabela,i);
            } 
            System.out.println(Global.gleda+" "+3*(Global.zamenjave-1));
            Global.gleda=0;
            Global.zamenjave=0;
            for(int i=(a/2)-1;i>=0;i--){
                heapifyd(tabela,a,i);
                //printArrayHeap(tabela,a);
                //Global.gleda++;
            }
            //System.out.println("*konec*");
            //printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
                Global.zamenjave++;
                // call max heapify on the reduced heap 
                heapifyd(tabela, i, 0); 
                //printArrayHeap(tabela,i);
            } 
            System.out.println(Global.gleda+" "+3*(Global.zamenjave-1));
        } else if(smer==0&&trco==0){
            Global.gleda=0;
            Global.zamenjave=0;
            for(int i=(a/2)-1;i>=0;i--){
                heapifyd(tabela,a,i);
                //printArrayHeap(tabela,a);
                //Global.gleda++;
            }
            //System.out.println("*konec*");
            //printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
                Global.zamenjave++;
                // call max heapify on the reduced heap 
                heapifyd(tabela, i, 0); 
                //printArrayHeap(tabela,i);
            } 
            System.out.println(Global.gleda+" "+3*(Global.zamenjave-1));
            Global.gleda=0;
            Global.zamenjave=0;
            for(int i=(a/2)-1;i>=0;i--){
                heapifyd(tabela,a,i);
                //printArrayHeap(tabela,a);
                //Global.gleda++;
            }
            //System.out.println("*konec*");
            //printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
                Global.zamenjave++;
                // call max heapify on the reduced heap 
                heapifyd(tabela, i, 0); 
                //printArrayHeap(tabela,i);
            } 
            System.out.println(Global.gleda+" "+3*(Global.zamenjave-1));
            Global.gleda=0;
            Global.zamenjave=0;
            for(int i=(a/2)-1;i>=0;i--){
                heapify(tabela,a,i);
                //printArray(tabela);
                //Global.gleda++;
            }
            //System.out.println("*konec*");
            //printArrayHeap(tabela,a);
            
            for (int i=a-1; i>=0; i--) {
                // Move current root to end 
                int temp = tabela[0]; 
                tabela[0] = tabela[i]; 
                tabela[i] = temp; 
                Global.zamenjave++;
                // call max heapify on the reduced heap 
                heapify(tabela, i, 0); 
                //printArrayHeap(tabela,i);
            } 
            System.out.println(Global.gleda+" "+3*(Global.zamenjave-1));
        }
    }


    public static void sort1(int[] tabela,int low, int high){
        //System.out.println("low:"+low+" high:"+high);
        if(tabela==null||tabela.length==0){
            return;
        }
        if(low>=high){
            return;
        }
        int middle=low+(high-low)/2;
        int pivot=tabela[middle];
        int i=low,j=high;
        while(i<=j){
            while(tabela[i]<pivot){
                i++;
            }
            while(tabela[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp=tabela[i];
                tabela[i]=tabela[j];
                tabela[j]=temp;
                i++;
                j--;
            }
        }
        //System.out.println("i:"+i+" j:"+j);
        for(int c=low;c<=high;c++){
            
            if(c==i){
                System.out.print("| ");
            }
            if(c==j+1){
                System.out.print("| ");
            }
            System.out.print(tabela[c]+" ");
        }
        System.out.println();
        if(low<j){
            sort1(tabela, low, j);
        }
        if(high>i){
            sort1(tabela, i, high);
        }
    }

    public static void sort2(int[] tabela,int low, int high){
        //System.out.println("low:"+low+" high:"+high);
        if(tabela==null||tabela.length==0){
            return;
        }
        if(low>=high){
            return;
        }
        int middle=low+(high-low)/2;
        int pivot=tabela[middle];
        int i=low,j=high;
        while(i<=j){
            while(tabela[i]>pivot){
                i++;
            }
            while(tabela[j]<pivot){
                j--;
            }
            if(i<=j){
                int temp=tabela[i];
                tabela[i]=tabela[j];
                tabela[j]=temp;
                i++;
                j--;
            }
        }
        //System.out.println("i:"+i+" j:"+j);
        for(int c=low;c<=high;c++){
            
            if(c==i){
                System.out.print("| ");
            }
            if(c==j+1){
                System.out.print("| ");
            }
            System.out.print(tabela[c]+" ");
        }
        System.out.println();
        if(low<j){
            sort2(tabela, low, j);
        }
        if(high>i){
            sort2(tabela, i, high);
        }
    }
    public static void sort3(int[] tabela,int low, int high){
        //System.out.println("low:"+low+" high:"+high);
        if(tabela==null||tabela.length==0){
            
            return;
        }
        if(low>=high){
            //Global.gleda++;
            
            return;
        }
        //Global.zamenjave++;
        int middle=low+(high-low)/2;
        int pivot=tabela[middle];
        int i=low,j=high;
        while(i<=j){
            while(tabela[i]<pivot){
                i++;
                Global.gleda++;
            }
            while(tabela[j]>pivot){
                j--;
                Global.gleda++;
            }
            if(i<=j){
                Global.zamenjave++;
                int temp=tabela[i];
                tabela[i]=tabela[j];
                tabela[j]=temp;
                i++;
                j--;
            }
            Global.gleda++;
        }
        //Global.gleda++;
        //System.out.println("i:"+i+" j:"+j);
        
        if(low<j){
            Global.gleda++;
            sort3(tabela, low, j);
        }
        if(high>i){
            Global.gleda++;
            sort3(tabela, i, high);
        }
    }
    public static void sort4(int[] tabela,int low, int high){
        //System.out.println("low:"+low+" high:"+high);
        if(tabela==null||tabela.length==0){
            return;
        }
        if(low>=high){
            //Global.gleda++;
            return;
        }
        //Global.zamenjave++;
        int middle=low+(high-low)/2;
        int pivot=tabela[middle];
        int i=low,j=high;
        while(i<=j){
            while(tabela[i]>pivot){
                Global.gleda++;
                i++;
            }
            while(tabela[j]<pivot){
                Global.gleda++;
                j--;
            }
            if(i<=j){
                Global.zamenjave++;
                int temp=tabela[i];
                tabela[i]=tabela[j];
                tabela[j]=temp;
                i++;
                j--;
            }
            Global.gleda++;
        }
        //System.out.println("i:"+i+" j:"+j);
        
        if(low<j){
            Global.gleda++;
            sort4(tabela, low, j);
        }
        if(high>i){
            Global.gleda++;
            sort4(tabela, i, high);
        }
    }

    public static void quick(int[] tabela,int smer,int trco){
        int n=tabela.length;
        if(smer==1&&trco==1){
            sort1(tabela,0,n-1);
        } else if(smer==0&&trco==1){
            sort2(tabela,0,n-1);
        } else if(smer==1&&trco==0){
            Global.gleda=0;
            Global.zamenjave=0;
            sort3(tabela,0,n-1);
            System.out.println(Global.gleda+" "+Global.zamenjave);
            Global.gleda=0;
            Global.zamenjave=0;
            sort3(tabela,0,n-1);
            System.out.println(Global.gleda+" "+Global.zamenjave);
            Global.gleda=0;
            Global.zamenjave=0;
            sort4(tabela,0,n-1);
            System.out.println(Global.gleda+" "+Global.zamenjave);
        } else if(smer==0&&trco==0){
            Global.gleda=0;
            Global.zamenjave=0;
            sort4(tabela,0,n-1);
            System.out.println(Global.gleda+" "+Global.zamenjave);
            Global.gleda=0;
            Global.zamenjave=0;
            sort4(tabela,0,n-1);
            System.out.println(Global.gleda+" "+Global.zamenjave);
            Global.gleda=0;
            Global.zamenjave=0;
            sort3(tabela,0,n-1);
            System.out.println(Global.gleda+" "+Global.zamenjave);
        }
    }

    public static void mergeb(int[] tabela,int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;

        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=tabela[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=tabela[mid+i+1];
        }

        int i=0,j=0,k=l;
        while(i<n1&&j<n2){
            if(L[i] <=R[j]){
                tabela[k]=L[i];
                i++;
            } else {
                tabela[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            tabela[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            tabela[k]=R[j];
            j++;
            k++;
        }
    }

    public static void mergec(int[] tabela,int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;

        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=tabela[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=tabela[mid+i+1];
        }

        int i=0,j=0,k=l;
        while(i<n1&&j<n2){
            if(L[i] >=R[j]){
                tabela[k]=L[i];
                i++;
            } else {
                tabela[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            tabela[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            tabela[k]=R[j];
            j++;
            k++;
        }
    }

    public static void sortm1(int[] tabela,int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            for(int i=l;i<=r;i++){
                System.out.print(tabela[i]+" ");
                if(i==mid){
                    System.out.print("| ");
                }
            }
            System.out.println();
            sortm1(tabela,l,mid);
            sortm1(tabela,mid+1,r);
            mergeb(tabela,l,mid,r);
            for(int i=l;i<=r;i++){
                System.out.print(tabela[i]+" ");
                
            }
            System.out.println();
        }
    }

    public static void sortm2(int[] tabela,int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            for(int i=l;i<=r;i++){
                System.out.print(tabela[i]+" ");
                if(i==mid){
                    System.out.print("| ");
                }
            }
            System.out.println();
            sortm2(tabela,l,mid);
            sortm2(tabela,mid+1,r);
            mergec(tabela,l,mid,r);
            for(int i=l;i<=r;i++){
                System.out.print(tabela[i]+" ");
                
            }
            System.out.println();
        }
    }

    public static void merge(int[]tabela,int smer,int trco){
        int n=tabela.length;
        if(smer==1&&trco==1){
            sortm1(tabela,0,n-1);
        } else if(smer==0&&trco==1){
            sortm2(tabela, 0, n-1);
        } else if(smer==1&&trco==0){

        } else if(smer==0&&trco==0){

        }
    }

    public static void counting(int[] tabela,int smer, int trco){
        int n=tabela.length;
        if(smer==1&&trco==1){
            int[] out=new int[n];
            int[] count=new int[257];
            for(int i=0;i<=256;i++){
                count[i]=0;
            }
            for(int i=0;i<n;i++){
                count[tabela[i]]++;
            }
            for(int i=1;i<=256;i++){
                count[i] +=count[i-1];
                System.out.print(count[i-1]+" ");
            }
            System.out.println();
            for(int i=n-1;i>=0;i--){
                System.out.print(count[tabela[i]]-1+" ");
                out[count[tabela[i]]-1] = tabela[i];
                //System.out.print(count[tabela[i]-1]+" ");
                count[tabela[i]]--;
                
            }
            /*for(int i=0;i<n;i++){
                System.out.print(count[i]+" ");
            }*/
            
            System.out.println();
            for(int i=0;i<n;i++){
                tabela[i]=out[i];
                System.out.print(out[i]+" ");
            }
            System.out.println();
        } 
    }

    public static void rcount(int[] tabela, int size, int place){
        int[] output = new int[size + 1];
        int max = tabela[0];
        for (int i = 1; i < size; i++) {
            if (tabela[i] > max)
                max = tabela[i];
        }
        int[] count = new int[257];

        for (int i = 0; i <= 256; ++i){
            count[i] = 0;
        }

        // Calculate count of elements
        for (int i = 0; i < size; i++){
            count[(tabela[i] / place) % 10]++;
        }

        // Calculate cummulative count
        for (int i = 1; i <= 256; i++){
            count[i] += count[i - 1];
            System.out.print(count[i]+" ");
        }
        System.out.println();

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(count[(tabela[i]/place)%10]-1+" ");
            output[count[(tabela[i] / place) % 10] - 1] = tabela[i];
            count[(tabela[i] / place) % 10]--;
        }
        System.out.println();

        for (int i = 0; i < size; i++){
            tabela[i] = output[i];
            System.out.print(output[i]+" ");
        }
        System.out.println();
    }

    public static void radix(int[] tabela,int smer,int trco){
        int n=tabela.length;
        int max = tabela[0];
        for(int i=1;i<n;i++){
            if(tabela[i] >max){
                max=tabela[i];
            }
        }
        for(int i=1;max/i>0;i*=10){
            rcount(tabela,n,i);
            /*for(int j=0;j<n;j++){
                System.out.print(tabela[j]+" ");
            }
            System.out.println();*/
        }
        /*for(int j=0;j<n;j++){
            System.out.print(tabela[j]+" ");
        }
        System.out.println();*/
        
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String asd = sc.nextLine();
        String[] navodila = asd.split(" ");
        int kol = Integer.parseInt(navodila[3]);
        int tabela[] = new int[kol];
        int trco = 0;
        int smer = 0;
        if(navodila[2].equals("up")){
            smer=1;
        }
        //System.out.println(navodila[0] + " "+navodila[1]+ " "+ navodila[2]+ " "+navodila[3]);
        if(navodila[0].equals("trace")){
            trco = 1;
        }
        for(int i=0;i<kol;i++){
            tabela[i] = sc.nextInt();
        }
        if(navodila[1].equals("bs")){
            bubble(tabela,smer,trco);
        } else if (navodila[1].equals("ss")){
            selection(tabela,smer,trco);
        } else if (navodila[1].equals("is")){
            insertion(tabela,smer,trco);
        } else if (navodila[1].equals("hs")){
            heapSort(tabela,smer,trco);
        } else if (navodila[1].equals("qs")){
            quick(tabela,smer,trco);
        } else if (navodila[1].equals("ms")){
            merge(tabela,smer,trco);
        } else if(navodila[1].equals("cs")){
            counting(tabela,smer,trco);
        } else if(navodila[1].equals("rs")){
            radix(tabela, smer, trco);
        }


        sc.close();
    }

}