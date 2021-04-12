import java.util.Scanner;
import java.lang.Math;

public class izziv5 {
    public static int merge(int[] vhod,int prvi,int zadnji){
        if(prvi==zadnji){
            System.out.println("["+vhod[prvi]+"]: "+vhod[prvi]);
            return vhod[prvi];
        } else {
            int a=merge(vhod,prvi,(prvi+zadnji)/2);
            int b=merge(vhod,(prvi+zadnji)/2+1,zadnji);
            int zac=vhod[(prvi+zadnji)/2]+vhod[(prvi+zadnji)/2+1];
            int max = zac;
            int temp = zac;
            //System.out.println("zac="+zac+" prvi="+prvi+" pol="+(zadnji-prvi-2)/2+","+((zadnji-prvi-2)/2+1)+" zadnji="+zadnji);
            for(int i=(prvi+zadnji)/2-1;i>=prvi;i--){
                temp=temp+vhod[i];
                //System.out.println("*i="+i+" temp="+temp+" max="+max);
                if(temp>max){
                    max=temp;
                }
            }
            temp=max;
            for(int i=(prvi+zadnji)/2+2;i<=zadnji;i++){
                temp=temp+vhod[i];
                //System.out.println("**i="+i+" temp="+temp+" max="+max);
                if(temp>max){
                    max=temp;
                }
            }
            System.out.print("[");
            for(int i=prvi;i<zadnji;i++){
                System.out.print(vhod[i]+", ");
            }
            System.out.print(vhod[zadnji]+"]: ");
            System.out.println(Math.max(a,Math.max(b,max)));
            return Math.max(a,Math.max(b,max));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String vhodS= sc.nextLine();
        String[] vmes = vhodS.split(" ");
        int[] vhod = new int[vmes.length];
        for(int i=0;i<vmes.length;i++){
            vhod[i] = Integer.parseInt(vmes[i]);
            //System.out.println(vhod[i]);
        }
        merge(vhod,0,vhod.length-1);
        sc.close();
    }
}