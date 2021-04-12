import java.util.ArrayList;
import java.util.Scanner;

public class izziv11 {

    public static class stvar{
        //int id;
        int volumen;
        int cena;

        public stvar(int b,int c){
            //id=a;
            volumen=b;
            cena=c;
        }
    }


    public static stvar[] sort(stvar[] prej){
        int n = prej.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (prej[j].volumen > prej[j+1].volumen) 
                { 
                    // swap arr[j+1] and arr[i] 
                    stvar temp = prej[j]; 
                    prej[j] = prej[j+1]; 
                    prej[j+1] = temp; 
                } else if(prej[j].volumen==prej[j+1].volumen){
                    if(prej[j].cena<prej[j+1].cena){
                        stvar temp = prej[j]; 
                        prej[j] = prej[j+1]; 
                        prej[j+1] = temp;
                    }
                }
                


        return prej;
    }
    
    public static void delaj(int vol,stvar[] tabela,int curr,stvar[] prej){

        /* System.out.print("na zacetku: "+curr+": ");
        for(int i=0;i<prej.length;i++){
            System.out.print("("+prej[i].volumen+", "+prej[i].cena+") ");
        }
        System.out.println(); */


        stvar[] vmes = new stvar[prej.length*2];
        for(int i=0;i<prej.length;i++){
            vmes[i]=prej[i];
        }
        int tv=tabela[curr].volumen;
        int tc=tabela[curr].cena;
        int pd=prej.length;
        for(int i=prej.length;i<vmes.length;i++){
            vmes[i]=new stvar(prej[i-pd].volumen+tv,prej[i-pd].cena+tc);
        }
        vmes=sort(vmes);
        /*System.out.print("vse pred rezanjem: "+curr+": ");
        for(int i=0;i<vmes.length;i++){
            System.out.print("("+vmes[i].volumen+", "+vmes[i].cena+") ");
        }
        System.out.println();*/
        
        ArrayList<stvar> tko=new ArrayList<stvar>();
        for(int i=0;i<vmes.length;i++){
            //System.out.println("gledam za: ("+vmes[i].volumen+", "+vmes[i].cena+") ");
            int remove=0;
            if(vmes[i].volumen>vol){
                //System.out.println("*prevelik volumen!");
                remove=1;
                
            }
            /*for(int j=0;j<vmes.length;j++){
                if(j==i){
                    j++;
                    if(j>=vmes.length){
                        break;
                    }
                }
                if(vmes[i].volumen>vol){
                    //System.out.println("*prevelik volumen!");
                    remove=1;
                    break;
                }
                if(vmes[i].cena<=vmes[j].cena&&vmes[i].volumen>=vmes[j].volumen){
                    //System.out.print("*eliminira ga: ("+prej[j].volumen+", "+prej[j].cena+") ");
                    remove=1;
                    break;
                }
            }*/
            for(int j=0;j<tko.size();j++){
                
                if(vmes[i].volumen>vol){
                    //System.out.println("*prevelik volumen!");
                    remove=1;
                    break;
                }
                if(vmes[i].cena<=tko.get(j).cena&&vmes[i].volumen>=tko.get(j).volumen){
                    //System.out.print("*eliminira ga: ("+prej[j].volumen+", "+prej[j].cena+") ");
                    remove=1;
                    break;
                }
            }
            if(remove==0){
                tko.add(vmes[i]);
            }
        }
        

        stvar[] naprej=tko.toArray(new stvar[0]);

        /*System.out.print("pred sort: "+curr+": ");
        for(int i=0;i<naprej.length;i++){
            System.out.print("("+naprej[i].volumen+", "+naprej[i].cena+") ");
        }
        System.out.println();*/

        naprej=sort(naprej);
        System.out.print((curr+1)+": ");
        for(int i=0;i<naprej.length;i++){
            System.out.print("("+naprej[i].volumen+", "+naprej[i].cena+") ");
        }
        System.out.println();

        if(curr!=tabela.length-1)
            delaj(vol,tabela,curr+1,naprej);


    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int vol=sc.nextInt();
        int kol=sc.nextInt();
        //int[][] set=new int[kol][2];
        stvar[] tabela=new stvar[kol];
        
        for(int i=0;i<kol;i++){
            int b=sc.nextInt();
            int c=sc.nextInt();
            tabela[i]= new stvar(b,c);
        }
        stvar[] nic=new stvar[1];
        nic[0]= new stvar(0,0);
        System.out.println("0: (0, 0)");
        delaj(vol,tabela,0,nic);


        sc.close();
    }

}