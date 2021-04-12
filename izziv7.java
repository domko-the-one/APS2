import java.util.Scanner;

public class izziv7 {
    
    public static int powermod(int x,int y,int p){
        int res = 1;      
         
         
        x = x % p;  
  
        if (x == 0) return 0;   
  
        while (y > 0) { 
             
            if((y & 1)==1) {
                res = (res * x) % p; 
            }
            
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
        
    }

    public static int power(int a,int b){
        int c=a;
        for(int i=1;i<b;i++){
            a=a*c;
            
        }
        if(b==0){
            return 1;
        }
        return a;
        
    }



    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        int[] koreni = new int[100];
        int st=0;
        int prastevilo;

        //System.out.println(powermod(3,6,7));

        for(int i=n+1;true;i++){
            int pra=0;
            for(int j=2;j<n+1;j++){
                int temp=i/j;
                //System.out.println("temp: "+temp+" j: "+j+" i: "+i);
                if(temp*j==i){
                    pra=1;
                    break;
                }
            }
            if(pra==0){
                //System.out.println("stevilo: "+i);
                for(int j=2;j<i;j++){
                    //System.out.println("za j: "+j+" je mod: "+powermod(j,n,i));
                    if(powermod(j,n,i)==1){
                        int[] vmes=new int[i];
                        for(int m=1;m<n;m++){
                            //System.out.println("za st: "+j+" najdeni mod: "+powermod(j,m,i));
                            vmes[powermod(j, m, i)]++;
                        }
                        int nese=0;
                        for(int m=0;m<i;m++){
                            //System.out.print(vmes[m]+" ");
                            if(vmes[m]>1){
                                nese=1;
                            }
                        }
                        //System.out.println();



                        if(nese==0){
                            koreni[st]=j;
                            st++;
                        }
                    }
                }
            }
            if(st!=0){
                prastevilo=i;
                break;
            }
        }
        
        int manjsi=100000;
        System.out.print(prastevilo+": ");
        for(int i=0;koreni[i]!=0;i++){
            System.out.print(koreni[i]+" ");
            if(koreni[i]<manjsi){
                manjsi=koreni[i];
            }
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int vrednost;
                if(j>=i){
                    vrednost=(powermod(power(manjsi,i),j,prastevilo));
                } else{
                    vrednost=(powermod(power(manjsi,j),i,prastevilo));
                }
                if(j==0){
                    System.out.printf("%2d",vrednost);
                } else {
                    System.out.printf("%3d",vrednost);
                }
                
            }
            System.out.println();
        }



        
    }

}