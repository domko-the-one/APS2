import java.util.Scanner;

public class izziv3{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] tabela1=new int[a];
        int[] tabela2=new int[b];

        for(int i=0;i<a;i++){
            tabela1[i]=sc.nextInt();
        }
        for(int i=0;i<b;i++){
            tabela2[i]=sc.nextInt();
        }
        int[] konec= new int[a+b];
        char[] crke=new char[a+b];
        int j=0;
        int k=0;
        for(int i=0;i<a+b;i++){
            if(j==a){
                
                crke[i]='b';
                konec[i]=tabela2[k];
                //System.out.println("1. konec: "+konec[i]+" i: "+i);
                k++;
            } else if (k==b){
                crke[i]='a';
                konec[i]=tabela1[j];
                //System.out.println("2. konec: "+konec[i]+" i: "+i);
                j++;
            } else if(tabela1[j]<=tabela2[k]){
                crke[i]='a';
                konec[i]=tabela1[j];
                //System.out.println("3. konec: "+konec[i]+" i: "+i);
                j++;
            } else if(tabela1[j]>tabela2[k]){
                crke[i]='b';
                konec[i]=tabela2[k];
                //System.out.println("4. konec: "+konec[i]+" i: "+i);
                k++;
            }
        }
        for(int i=0;i<a+b;i++){
            System.out.print(crke[i]);
        }
        System.out.println();
        System.out.print(konec[0]);
        for(int i=1;i<a+b;i++){
            System.out.print(" "+konec[i]);
        }
        sc.close();
    }

}