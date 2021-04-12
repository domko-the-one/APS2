import java.util.Scanner;

public class izziv4{

    public static int enke(int stevilo){
        int konec=0;
        int vmes=0;
        while(stevilo>0){
            vmes = stevilo%2;
            stevilo = stevilo/2;
            if(vmes == 1){
                konec++;
            }
        }
        return konec;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] tabela= new int[a];
        int[] tabela3= new int[33];
        for(int i=0;i<33;i++){
            tabela3[i]=0;
        }
        for (int i=0;i<a;i++){
            tabela[i]= sc.nextInt();
        }
        int[] tabela2=new int[a];
        for(int i=0;i<a;i++){
            tabela2[i]=enke(tabela[i]);
            tabela3[tabela2[i]]++;
        }
        for(int i=1;i<33;i++){
            tabela3[i]= tabela3[i]+tabela3[i-1];
        }
        int[] konec=new int[a];
        for(int i=a-1;i>=0;i--){
            tabela3[tabela2[i]]--;
            int j=tabela3[tabela2[i]];
            
            konec[j]=tabela[i];
            System.out.println("("+tabela[i]+","+tabela3[tabela2[i]]+")");
        }
        for(int i=0;i<a;i++){
            System.out.print(konec[i]+" ");
        }


        sc.close();
    }

}