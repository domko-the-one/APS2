import java.util.Random;

public class iskanje{

    public static int[] generateTable(int n){
        int[] table = new int[n];
        for (int i=0; i<n;i++){
            table[i] = i+1;
        }
        return table;
    }

    public static int findLinear(int[] a, int v){
        for(int i =0;i<a.length;i++){
            if(a[i] == v){
                return i;
            }
        }
        return -1;
    }

    public static int findBinary(int[] a, int l, int r, int v){
        if(a[l+(r-l)/2]==v){
            //System.out.println("***enako: " + a[(l+(r-l)/2)]);
            return l+(r-l)/2;
        } else if(a[l+(r-l)/2]>v){
            //System.out.println("manj: " + a[(l+(r-l)/2)]);
            return findBinary(a, l, l+(r-l)/2, v);
        } else if(a[l+(r-l)/2]<v){
            //System.out.println("vec: " + a[(l+(r-l)/2)]);
            return findBinary(a, l+(r-l)/2, r, v);
        }
        return -1;
    }

    public static long timeLinear(int n){
        int[] tabela= generateTable(n);
        Random rand = new Random(); 
        long startTime = System.nanoTime();
        for(int i =0;i<1000;i++){
            int randint = rand.nextInt(n-1);
            randint++;
            findLinear(tabela, randint);
        }
        long executionTime = System.nanoTime() - startTime;
        return executionTime/1000;
    }

    public static long timeBinary(int n){
        int[] tabela= generateTable(n);
        Random rand = new Random();
        long startTime = System.nanoTime();
        for(int i =0;i<1000;i++){
            int randint = rand.nextInt(n-1);
            randint++;
            //System.out.println("iscemo: "+ randint);
            findBinary(tabela, 0, n, randint);
        }
        long executionTime = System.nanoTime() - startTime;
        return executionTime/1000;
    }

    public static void main(String[] args){
        //System.out.println("Linearni cas: "+timeLinear(1000));
        //System.out.println("Binarni cas: "+timeBinary(1000));
        System.out.println("   n     |    linearno  |   dvojisko   |");
        System.out.println("---------+--------------+---------------");
        for (int i=1000;i<100001;i=i+1000){
            System.out.printf("%8d |%13d |%13d  %n",i,timeLinear(i),timeBinary(i));
        }
    }
}