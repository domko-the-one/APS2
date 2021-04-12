import java.util.Scanner;

public class izziv10 {


    public static int min(int a,int b){
        if(a>=b){
            return b;
        } else return a;
    }

    public static int max(int a,int b){
        if(a>=b){
            return a;
        } else return b;
    }
    
    public static int jajca(int n, int k){
        //int[][] tabela=new int[n+1][k+1];
        if(n==0){
            return 0;
        }else if(k==1){
            return n;
        }else if(n==1){
            return 1;
        }
        int vmes=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            vmes=min(vmes,max(jajca(i-1,k-1),jajca(n-i,k)));
        }


        return 1+vmes;
    }



    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int nads=sc.nextInt();
        int koli=sc.nextInt();
        //System.out.println(jajca(nads,koli));

        int[][] tabela=new int[nads+1][koli+1];
        for(int i=1;i<=koli;i++){
            tabela[1][i]=1;
            tabela[0][i]=0;
        }
        for(int i=1;i<=nads;i++){
            tabela[i][1]=i;
        }

        for(int i=2;i<=nads;i++){
            for(int j=2;j<=koli;j++){
                int vmes=Integer.MAX_VALUE;
                for(int x=1;x<=i;x++){
                    vmes=min(vmes,1+max(tabela[x-1][j-1],tabela[i-x][j]));
                }
                tabela[i][j]=vmes;
            }
        }

        System.out.print("    ");
        for(int i=1;i<=koli;i++){
            System.out.printf("%4d", i);
        }
        System.out.println();
        for(int i=0;i<=nads;i++){
            System.out.printf("%4d", i);
            for(int j=1;j<=koli;j++){
                System.out.printf("%4d", tabela[i][j]);
            }
            System.out.println();
        }





        sc.close();
    }
}