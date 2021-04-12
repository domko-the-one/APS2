import java.util.Scanner;

public class Naloga2 {

    public static class bigBoi{
        String val;
        int baza;

        public bigBoi(String vall, int bazaa){
            val=vall;
            baza=bazaa;
        }

        public int basetodec(int index){
            if(index<0){
                return 0;
            }
            char to=val.charAt(index);
            //System.out.print("char: "+to);
            int nazaj=(int)to;
            if(nazaj==0){
                nazaj=48;
            }
            if(nazaj>=48&&nazaj<=57){
                nazaj=nazaj-48;
            } else{
                nazaj=nazaj-87;
            }
            //System.out.println(" dec: "+nazaj);
            return nazaj;
        }

        public char dectobase(int dec){
            //System.out.print("dec: "+dec);
            char nazaj=(char)dec;
            if(dec>=0&&dec<=9){
                nazaj +=48;
            } else {
                nazaj+=87;
            }
            //System.out.println(" char: "+nazaj);
            return nazaj;
        }

        public bigBoi add(bigBoi b){
            String nazaj="";
            int dol;
            //int kera=0;
            
            if(this.val.length()>b.val.length()){
                dol=this.val.length();
            } else {
                dol=b.val.length();
                //kera=1;
            }
            
            //cifra c=new cifra(nazaj,baza);
            int da=this.val.length();
            int db=b.val.length();
            if(da==0){
                nazaj=b.val;
                return new bigBoi(nazaj,baza);
            } else if(db==0){
                nazaj=this.val;
                return new bigBoi(nazaj,baza);
            }
            int kaaa=0;
            for(int i=0;i<dol;i++){
                //System.out.println("da:"+da+" db:"+db);
                int vmes=0;
                
                vmes=this.basetodec(da-1-i)+b.basetodec(db-1-i);
                if(kaaa==1){
                    vmes++;
                }
                //System.out.println("vmes: "+vmes);
                if(vmes-baza>=0){
                    nazaj=dectobase(vmes-baza)+nazaj;
                    kaaa=1;
                } else if(vmes-baza<0){
                    nazaj=dectobase(vmes)+nazaj;
                    kaaa=0;
                }
                
                
            }
            if(kaaa==1){
                nazaj="1"+nazaj;
            }
            return new bigBoi(nazaj,baza);
        }
        public bigBoi times(bigBoi b){
            bigBoi nazaj=new bigBoi("",baza);
            for(int i=0;i<b.val.length();i++){
                bigBoi vmes=new bigBoi("",baza);
                
                for(int j=0;j<b.basetodec(i);j++){
                    vmes=vmes.add(this);
                }
                nazaj.val=nazaj.val+"0";
                //System.out.println("nazaj: "+nazaj.val+" vmes: "+vmes.val);
                nazaj=nazaj.add(vmes);
                vmes.val="";
            }
            return nazaj;
        }
        public bigBoi minus(bigBoi b){
            //String to=this.val;
            String nazaj="";
            if(b.val.length()==0||b.val.equals("0")){
                return new bigBoi(val,baza);
            }
            int da=val.length();
            int db=b.val.length();
            int kaaa=0;
            for(int i=0;i<val.length();i++){
                //System.out.println("da:"+da+" db:"+db);
                int vmes=0;
                
                vmes=this.basetodec(da-1-i)-b.basetodec(db-1-i);
                if(kaaa==1){
                    vmes--;
                }
                //System.out.println("vmes: "+vmes+" baza: "+baza);
                if(vmes<0){
                    //System.out.println("znotraj: "+(baza+vmes)+" dec to base: "+dectobase(baza+vmes));
                    nazaj=dectobase(baza+vmes)+nazaj;
                    kaaa=1;
                } else if(vmes>=0){
                    nazaj=dectobase(vmes)+nazaj;
                    kaaa=0;
                }
                
                
            }
            if(nazaj.charAt(0)=='0'){
                nazaj=nazaj.substring(1);
            }
            return new bigBoi(nazaj, baza);
        }
    }

    public static class cifra{
        char[] num;
        int baza;

        public cifra(){
            
            
        }

        public cifra(char[] numb,int bazaa){
            num=numb;
            baza=bazaa;
        }

        public int convertToDecimal(char[] cha, int base) {
            int v = 0;
            int total = 0;
            int pow = 0;
            //str = str.toUpperCase();
            for (int i = cha.length - 1; i >= 0; i--) {
                char c = cha[i];
                if (c >= '0' && c <= '9')
                    v = c - '0';
                else if (c >= 'a' && c <= 'z')
                    v = 10 + (c - 'a');
                total += v * power(base, pow);
                pow++;
            }
            return total;
        }

        public int basetodec(int index){
            if(index<0){
                return 0;
            }
            char to=num[index];
            //System.out.print("char: "+to);
            int nazaj=(int)to;
            if(nazaj==0){
                nazaj=48;
            }
            if(nazaj>=48&&nazaj<=57){
                nazaj=nazaj-48;
            } else{
                nazaj=nazaj-87;
            }
            //System.out.println(" dec: "+nazaj);
            return nazaj;
        }

        public char dectobase(int dec){
            //System.out.print("dec: "+dec);
            char nazaj=(char)dec;
            if(dec>=0&&dec<=9){
                nazaj +=48;
            } else {
                nazaj+=87;
            }
            //System.out.println(" char: "+nazaj);
            return nazaj;
        }

        public cifra celavbazo(int cela){
            char[] test=new char[1];
            String vmes=Integer.toString(cela);
            String nazaj=Integer.toString(Integer.parseInt(vmes,10),baza);
            char[] tole=nazaj.toCharArray();
            cifra nazaj1=new cifra(test,baza);
            nazaj1.num=tole;
            return nazaj1;
        }   

        public int bazavcelo(){
            String vmes="";
            for(int i=0;i<this.num.length;i++){
                //System.out.println(this.num[i]+"**");
                vmes=vmes+this.num[i];
                
            }
            if(this.num.length==1&&this.num[0]==0){
                vmes="0";
            }
            //System.out.println("baza v celo:"+vmes);
            
            String nazaj=Integer.toString(Integer.parseInt(vmes,baza),10);
            return Integer.parseInt(nazaj);
        }

        public void vnesicifro(int kaj, int kam){
            //System.out.println("kaj: "+kaj+" kam: "+kam);
            if(this.num[kam]==49){
                kaj++;
            }
            if(kaj>=baza){
                int to=kaj-baza;
                this.num[kam]=dectobase(to);
                this.num[kam-1]=49;
            } else {
                this.num[kam]=dectobase(kaj);
            }
        }

        public void vnesicifrozamin(int kaj, int kam){
            //System.out.println("kaj: "+kaj+" kam: "+kam);
            if(this.num[kam]==49){
                kaj++;
            }
            if(kaj>=baza){
                int to=kaj-baza;
                this.num[kam]=dectobase(to);
                this.num[kam-1]=49;
            } else {
                this.num[kam]=dectobase(kaj);
            }
        }

        public cifra plus(cifra b){
            /*
            char[] test = new char[1];
            System.out.print("prvi faktor: ");
            for(int i=0;i<this.num.length;i++){
                System.out.print(this.num[i]);
            }
            System.out.println();
            System.out.print("drugi faktor: ");
            for(int i=0;i<b.num.length;i++){
                System.out.print(b.num[i]);
            }
            System.out.println();
            int p = this.bazavcelo();
            int d = b.bazavcelo();
            System.out.println("mnozim: "+p+" in: "+d);
            int backme=p+d;
            System.out.println("rezultat times v dec: "+backme);
            cifra zan=new cifra(test,baza);
            zan=celavbazo(backme);
            return zan;
            */



            
            int dol;
            //int kera=0;
            
            if(this.num.length>b.num.length){
                dol=this.num.length;
            } else {
                dol=b.num.length;
                //kera=1;
            }
            char[] nazaj=new char[dol+1];
            for(int i=0;i<dol+1;i++){
                nazaj[i]=0;
            }
            cifra c=new cifra(nazaj,baza);
            int da=this.num.length;
            int db=b.num.length;
            for(int i=0;i<dol;i++){
                //System.out.println("da:"+da+" db:"+db);
                int vmes=0;
                
                vmes=this.basetodec(da-1-i)+b.basetodec(db-1-i);
                //System.out.println("vmes: "+vmes);
                c.vnesicifro(vmes,dol-i);
                
                
            }
            if(c.num[0]==0){
                char[] nova=new char[dol];
                for(int i=0;i<dol;i++){
                    nova[i]=c.num[1+i];
                }
                cifra d=new cifra(nova,baza);
                return d;
            }
            return c;
            
        }

        public cifra minus(cifra b){
            int p = this.bazavcelo();
            int d = b.bazavcelo();

            int backme=p-d;
            //System.out.println("rezultat minus v dec: "+backme);
            cifra zan=celavbazo(backme);
            return zan;

        }

        public cifra times(cifra b){
            char[] test = new char[1];
            /*System.out.print("prvi faktor: ");
            for(int i=0;i<this.num.length;i++){
                System.out.print(this.num[i]);
            }
            System.out.println();
            System.out.print("drugi faktor: ");
            for(int i=0;i<b.num.length;i++){
                System.out.print(b.num[i]);
            }
            System.out.println();*/
            int p = this.bazavcelo();
            int d = b.bazavcelo();
            //System.out.println("mnozim: "+p+" in: "+d);
            int backme=p*d;
            //System.out.println("rezultat times v dec: "+backme);
            cifra zan=new cifra(test,baza);
            zan=celavbazo(backme);
            return zan;

            /*
            char[] test=new char[1];
            cifra c=new cifra(test,this.baza);
            for(int i=0;i<b.convertToDecimal(b.num, b.baza);i++){
                c=c.plus(this);
            }
            
            return c;
            */
        }
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

    public static class matrika{
        int[][]mat;

        public matrika(int[][] matr){
            mat=matr;
        }

        public int[][] vint(){
            return this.mat;
        }


    }

    public static void navmno(int[][] prva, int[][] druga){
        //System.out.println(prva.length+" "+prva[0].length+" "+druga.length+" "+druga[0].length);
        int[][] zmn=new int[prva.length][druga[0].length];
        System.out.println("DIMS: "+prva.length+"x"+druga[0].length);
        int vsota=0;
        for (int c = 0; c < prva.length; c++) {
            for (int d = 0; d < druga[0].length; d++) {
                for (int k = 0; k < druga.length; k++){
                    vsota = vsota + prva[c][k]*druga[k][d];
                }
                zmn[c][d] = vsota;
                vsota = 0;
            }
        }
        for(int i=0;i<zmn.length;i++){
            for(int j=0;j<zmn[0].length;j++){
                System.out.print(zmn[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] mnozi(int[][] prva, int[][] druga){
        //System.out.println(prva.length+" "+prva[0].length+" "+druga.length+" "+druga[0].length);
        int[][] zmn=new int[prva.length][druga[0].length];
        //System.out.println("DIMS: "+prva.length+"x"+druga[0].length);
        int vsota=0;
        for (int c = 0; c < prva.length; c++) {
            for (int d = 0; d < druga[0].length; d++) {
                for (int k = 0; k < druga.length; k++){
                    vsota = vsota + prva[c][k]*druga[k][d];
                }
                zmn[c][d] = vsota;
                vsota = 0;
            }
        }
        vsota=0;
        for(int i=0;i<zmn.length;i++){
            for(int j=0;j<zmn[0].length;j++){
                vsota=vsota +zmn[i][j];
            }
            //System.out.println();
        }
        System.out.println(vsota);
        return zmn;
    }

    public static int[][] add(int[][] prva, int[][] druga){
        int[][] vsota=new int[prva.length][prva[0].length];
        //printM(prva);
        //printM(druga);
        for(int i=0;i<prva.length;i++){
            for(int j=0;j<prva[0].length;j++){
                vsota[i][j]=prva[i][j]+druga[i][j];
            }
        }
        return vsota;
    }

    public static int[][] sub(int[][] prva,int[][] druga){
        int[][] sub=new int[prva.length][prva[0].length];
        for(int i=0;i<prva.length;i++){
            for(int j=0;j<prva[0].length;j++){
                sub[i][j]=prva[i][j]-druga[i][j];
            }
        }
        return sub;
    }

    public static int[][] getSubmatrix(int[][] matrika, int startRow, int startCol, int dim){
        
        int[][] subM=new int[dim][dim];
        if(startRow+dim-1>matrika[0].length&&startCol+dim-1>matrika.length){
            subM=new int[matrika.length-startCol+1][matrika[0].length-startRow+1];
        } else if(startRow+dim-1<=matrika[0].length&&startCol+dim-1>matrika.length){
            subM =new int[matrika.length-startCol+1][dim];
        } else if(startRow+dim-1>matrika[0].length&&startCol+dim-1<=matrika.length){
            subM=new int[dim][matrika[0].length-startRow+1];
        }
        /*int blok=dim;
        int j=startRow-1;
        int i=startCol-1;
        int a=matrika.length;
        int b=matrika[0].length;
        int[][] vsota= new int[blok][blok];
        System.out.println("a: "+a+" b: "+b+" startrow: "+startRow+" startcol: "+startCol);
        if(j+blok>a&&i+blok>b){
            System.out.println("a: "+a+" b: "+b+" startrow: "+startRow+" startcol: "+startCol);
            vsota=new int[a-i][b-j];
        } else if(j+blok>a&&i+blok<=b){
            System.out.println("a: "+a+" b: "+b+" startrow: "+startRow+" startcol: "+startCol);
            vsota = new int[a-i][blok];
        } else if(j+blok<=a&&i+blok>b){
            System.out.println("a: "+a+" b: "+b+" startrow: "+startRow+" startcol: "+startCol);
            vsota =new int[blok][b-j];
        }*/
        //System.out.println("subM:");
        //printM(subM);
        
        //System.out.println("******");

        for (int ii = 0; ii<subM.length ; ii++ ){

            for (int jj=0;jj<subM[0].length ; jj++ ){

                subM[ii][jj]=matrika[startCol+ii-1][startRow+jj-1];
            }

        }
        return subM;

    }

    public static void printM(int[][] matrika){
        for(int i=0;i<matrika.length;i++){
            for(int j=0;j<matrika[0].length;j++){
                System.out.print(matrika[i][j]+" ");
            }
            System.out.println();
        }
    } 

    public static int getOne(int row, int col, matrika[][] m){
        int gor=0;
        int levo=0;
        for(int i=0;i<m.length;i++){
            gor=gor+m[i][0].mat.length;
        }
        for(int i=0;i<m[0].length;i++){
            levo=levo+m[0][i].mat[0].length;
        }
        for(int i=0;i<gor;i++){
            for(int j=0;j<levo;j++){

            }
        }
        return -1;
    }

    

    public static void block(int[][] prva, int[][] druga, int blok){
        //int[][] zmn=new int[prva.length][druga[0].length];
        int a=0,b=0,c=0,d=0;
        if(prva.length%blok==0){
            a=prva.length/blok;
        } else {
            a=prva.length/blok+1;
        }
        if(prva[0].length%blok==0){
            b=prva[0].length/blok;
        } else {
            b=prva[0].length/blok+1;
        }
        if(druga.length%blok==0){
            c=druga.length/blok;
        } else {
            c=druga.length/blok+1;
        }
        if(druga[0].length%blok==0){
            d=druga[0].length/blok;
        } else {
            d=druga[0].length/blok+1;
        }

        matrika[][] odp= new matrika[a][b];
        matrika[][] odd= new matrika[c][d];
        int n=0;
        for(int i=0;i<prva.length;i+=blok){
            int m=0;
            for(int j=0;j<prva[0].length;j+=blok){
                odp[n][m] = new matrika(getSubmatrix(prva, i + 1, j + 1, blok));
                m++;
            }
            n++;
        }
        n=0;
        for(int i=0;i<druga.length;i+=blok){
            int m=0;
            for(int j=0;j<druga[0].length;j+=blok){
                odd[n][m] = new matrika(getSubmatrix(druga, i + 1, j + 1, blok));
                m++;
            }
            n++;
        }
        matrika[][] zmn=new matrika[odp.length][odd[0].length];
        for(int i=0;i<odp.length;i++){
            for(int j=0;j<odd[0].length;j++){
                int[][] vsota= new int[odp[i][0].mat.length][odp[i][0].mat.length];
                for(int k=0;k<odd.length;k++){
                    int[][] vmes= mnozi(odp[i][k].mat,odd[k][j].mat);
                    vsota=add(vsota,vmes);
                }
                zmn[i][j].mat=vsota;
            }
        }
    }

    public static void b2(int[][] prva, int[][] druga,int blok){
        int a1=0,a2=0,b1=0,b2=0;
        if(prva.length%blok==0){
            a1=prva.length/blok;
        } else {
            a1=prva.length/blok+1;
        }
        if(prva[0].length%blok==0){
            a2=prva[0].length/blok;
        } else {
            a2=prva[0].length/blok+1;
        }
        if(druga.length%blok==0){
            b1=druga.length/blok;
        } else {
            b1=druga.length/blok+1;
        }
        if(druga[0].length%blok==0){
            b2=druga[0].length/blok;
        } else {
            b2=druga[0].length/blok+1;
        }
        /*
        matrika[][] odp= new matrika[a1][a2];
        matrika[][] odd= new matrika[b1][b2];
        int n=0;
        for(int i=0;i<prva.length;i+=blok){
            int m=0;
            for(int j=0;j<prva[0].length;j+=blok){
                odp[n][m] = new matrika(getSubmatrix(prva, i + 1, j + 1, blok));
                m++;
            }
            n++;
        }
        n=0;
        for(int i=0;i<druga.length;i+=blok){
            int m=0;
            for(int j=0;j<druga[0].length;j+=blok){
                odd[n][m] = new matrika(getSubmatrix(druga, i + 1, j + 1, blok));
                m++;
            }
            n++;
        }
        */
        int[][] nazaj=new int[prva.length][druga[0].length];
        int a=prva.length;
        int b=druga[0].length;
        for(int i=0;i<prva.length;i=i+blok){
            for(int j=0;j<druga[0].length;j=j+blok){
                int[][] vsota= new int[blok][blok];
                if(i+blok>a&&j+blok>b){
                    vsota=new int[a-i][b-j];
                } else if(j+blok>b&&i+blok<=a){
                    vsota = new int[blok][b-j];
                } else if(j+blok<=b&&i+blok>a){
                    vsota =new int[a-i][blok];
                }
                
                
                for(int k=0;k<vsota.length;k++){
                    for(int h=0;h<vsota[0].length;h++){
                        vsota[k][h]=0;
                    }
                }
                //for(int kr=0;kr<druga[0].length;kr=kr+blok){
                    for(int k=0;k<prva[0].length;k=k+blok){
                        //System.out.println("prva,k+1:"+(k+1)+",i+1:"+(i+1)+",blok:"+blok);
                        //printM(getSubmatrix(prva, k+1, i+1, blok));
                        //System.out.println("druga,kr+1:"+(kr+1)+",k+1:"+(k+1)+",blok:"+blok);
                        //printM(getSubmatrix(druga, kr+1, k+1, blok));
                        //printM(vsota);
                        vsota=add(vsota,mnozi(getSubmatrix(prva, k+1, i+1, blok), getSubmatrix(druga, j+1, k+1, blok)));
                    }
                    
                //}
                for(int h=0;h<vsota.length;h++){
                    for(int in=0;in<vsota[0].length;in++){
                        nazaj[h+i][in+j]=vsota[h][in];
                    }
                }
            }
        }
        System.out.println("DIMS: "+nazaj.length+"x"+nazaj[0].length);
        printM(nazaj);
    }
    public static int vec(int a,int b){
        if(a>=b){
            return a;
        } else {
            return b;
        }
    }

    public static int[][] rekd(int[][] p,int[][] d,int blok){
        if(p.length==blok){
            return mnozi(p, d);
        }
        //System.out.println("length/2: "+p.length/2);
        int[][]nazaj=new int[p.length][p.length];
        int[][]a11=getSubmatrix(p, 1, 1, p.length/2);
        int[][]b11=getSubmatrix(d, 1, 1, p.length/2);
        int[][]a12=getSubmatrix(p, p.length/2+1, 1, p.length/2);
        int[][]b12=getSubmatrix(d, p.length/2+1, 1, p.length/2);
        int[][]a21=getSubmatrix(p, 1, p.length/2+1, p.length/2);
        int[][]b21=getSubmatrix(d, 1, p.length/2+1, p.length/2);
        int[][]a22=getSubmatrix(p, p.length/2+1, p.length/2+1, p.length/2);
        int[][]b22=getSubmatrix(d, p.length/2+1, p.length/2+1, p.length/2);
        //printM(a11);
        //printM(a12);
        //printM(a21);
        //printM(a22);
        int[][] prvi=add(rekd(a11,b11,blok),rekd(a12,b21,blok));
        int[][] drugi=add(rekd(a11,b12,blok),rekd(a12,b22,blok));
        int[][] tretji=add(rekd(a21,b11,blok),rekd(a22,b21,blok));
        int[][] cetrti=add(rekd(a21,b12,blok),rekd(a22,b22,blok));

        for(int i=0;i<p.length/2;i++){
            for(int j=0;j<p.length/2;j++){
                nazaj[i][j]=prvi[i][j];
            }
        }
        for(int i=0;i<p.length/2;i++){
            for(int j=p.length/2;j<p.length;j++){
                nazaj[i][j]=drugi[i][j-p.length/2];
            }
        }
        for(int i=p.length/2;i<p.length;i++){
            for(int j=0;j<p.length/2;j++){
                nazaj[i][j]=tretji[i-p.length/2][j];
            }
        }
        for(int i=p.length/2;i<p.length;i++){
            for(int j=p.length/2;j<p.length;j++){
                nazaj[i][j]=cetrti[i-p.length/2][j-p.length/2];
            }
        }
        int vsota=0;
        for(int i=0;i<p.length;i++){
            for(int j=0;j<p.length;j++){
                vsota=vsota+nazaj[i][j];
            }
        }
        System.out.println(vsota);
        return nazaj;
    }

    public static void dvlad(int[][]prva,int[][]druga,int blok){
        int dotu=vec(prva.length,vec(prva[0].length,vec(druga.length,druga[0].length)));
        int ind;
        for(ind=1;ind<dotu;ind=ind*2){

        }
        //System.out.println("dotu: "+dotu+"ind: "+ind);
        int[][] np=new int[ind][ind];
        int[][] nd=new int[ind][ind];
        for(int i=0;i<prva.length;i++){
            for(int j=0;j<prva[0].length;j++){
                np[i][j]=prva[i][j];
            }
        }
        for(int i=0;i<druga.length;i++){
            for(int j=0;j<druga[0].length;j++){
                nd[i][j]=druga[i][j];
            }
        }
        
        //int[][] nazaj=rekd(np,nd,blok);
        




        
        //System.out.println("length/2: "+np.length/2);
        int[][]nazaj=new int[np.length][np.length];
        int[][]a11=getSubmatrix(np, 1, 1, np.length/2);
        int[][]b11=getSubmatrix(nd, 1, 1, np.length/2);
        int[][]a12=getSubmatrix(np, np.length/2+1, 1, np.length/2);
        int[][]b12=getSubmatrix(nd, np.length/2+1, 1, np.length/2);
        int[][]a21=getSubmatrix(np, 1, np.length/2+1, np.length/2);
        int[][]b21=getSubmatrix(nd, 1, np.length/2+1, np.length/2);
        int[][]a22=getSubmatrix(np, np.length/2+1, np.length/2+1, np.length/2);
        int[][]b22=getSubmatrix(nd, np.length/2+1, np.length/2+1, np.length/2);
        //printM(a11);
        //printM(a12);
        //printM(a21);
        //printM(a22);
        int[][] prvi=add(rekd(a11,b11,blok),rekd(a12,b21,blok));
        int[][] drugi=add(rekd(a11,b12,blok),rekd(a12,b22,blok));
        int[][] tretji=add(rekd(a21,b11,blok),rekd(a22,b21,blok));
        int[][] cetrti=add(rekd(a21,b12,blok),rekd(a22,b22,blok));

        for(int i=0;i<np.length/2;i++){
            for(int j=0;j<np.length/2;j++){
                nazaj[i][j]=prvi[i][j];
            }
        }
        for(int i=0;i<np.length/2;i++){
            for(int j=np.length/2;j<np.length;j++){
                nazaj[i][j]=drugi[i][j-np.length/2];
            }
        }
        for(int i=np.length/2;i<np.length;i++){
            for(int j=0;j<np.length/2;j++){
                nazaj[i][j]=tretji[i-np.length/2][j];
            }
        }
        for(int i=np.length/2;i<np.length;i++){
            for(int j=np.length/2;j<np.length;j++){
                nazaj[i][j]=cetrti[i-np.length/2][j-np.length/2];
            }
        }
        int vsota=0;
        for(int i=0;i<np.length;i++){
            for(int j=0;j<np.length;j++){
                vsota=vsota+nazaj[i][j];
            }
        }





        System.out.println("DIMS: "+np.length+"x"+nd.length);
        printM(nazaj);
    }

    public static int[][] stras(int[][]np,int[][]nd,int blok){
        if(np.length==blok){
            return mnozi(np, nd);
        }


        int[][]nazaj=new int[np.length][np.length];
        int[][]a11=getSubmatrix(np, 1, 1, np.length/2);
        int[][]b11=getSubmatrix(nd, 1, 1, np.length/2);
        int[][]a12=getSubmatrix(np, np.length/2+1, 1, np.length/2);
        int[][]b12=getSubmatrix(nd, np.length/2+1, 1, np.length/2);
        int[][]a21=getSubmatrix(np, 1, np.length/2+1, np.length/2);
        int[][]b21=getSubmatrix(nd, 1, np.length/2+1, np.length/2);
        int[][]a22=getSubmatrix(np, np.length/2+1, np.length/2+1, np.length/2);
        int[][]b22=getSubmatrix(nd, np.length/2+1, np.length/2+1, np.length/2);
        int[][]p1=stras(a11, sub(b12,b22),blok);
        int[][]p2=stras(add(a11,a12), b22,blok);
        int[][]p3=stras(add(a21,a22),b11,blok);
        int[][]p4=stras(a22, sub(b21, b11),blok);
        int[][]p5=stras(add(a11,a22), add(b11,b22),blok);
        int[][]p6=stras(sub(a12,a22),add(b21,b22),blok);
        int[][]p7=stras(sub(a11,a21),add(b11,b12),blok);

        int[][]prvi=add(p5,add(p4,sub(p6,p2)));
        int[][]drugi=add(p1,p2);
        int[][]tretji=add(p3,p4);
        int[][]cetrti=add(sub(p1,p3),sub(p5,p7));

        for(int i=0;i<np.length/2;i++){
            for(int j=0;j<np.length/2;j++){
                nazaj[i][j]=prvi[i][j];
            }
        }
        for(int i=0;i<np.length/2;i++){
            for(int j=np.length/2;j<np.length;j++){
                nazaj[i][j]=drugi[i][j-np.length/2];
            }
        }
        for(int i=np.length/2;i<np.length;i++){
            for(int j=0;j<np.length/2;j++){
                nazaj[i][j]=tretji[i-np.length/2][j];
            }
        }
        for(int i=np.length/2;i<np.length;i++){
            for(int j=np.length/2;j<np.length;j++){
                nazaj[i][j]=cetrti[i-np.length/2][j-np.length/2];
            }
        }
        int vsota=0;
        for(int i=0;i<np.length;i++){
            for(int j=0;j<np.length;j++){
                vsota=vsota+nazaj[i][j];
            }
        }
        System.out.println(vsota);


        return nazaj;
    }

    public static void str(int[][]np,int[][]nd,int blok){
        int[][]prva=np;
        int[][]druga=nd;
        int dotu=vec(prva.length,vec(prva[0].length,vec(druga.length,druga[0].length)));
        int ind;
        for(ind=1;ind<dotu;ind=ind*2){

        }
        //System.out.println("dotu: "+dotu+"ind: "+ind);
        int[][] npi=new int[ind][ind];
        int[][] ndi=new int[ind][ind];
        for(int i=0;i<prva.length;i++){
            for(int j=0;j<prva[0].length;j++){
                npi[i][j]=prva[i][j];
            }
        }
        for(int i=0;i<druga.length;i++){
            for(int j=0;j<druga[0].length;j++){
                ndi[i][j]=druga[i][j];
            }
        }



        


        int[][]nazaj=new int[npi.length][npi.length];
        int[][]a11=getSubmatrix(npi, 1, 1, npi.length/2);
        int[][]b11=getSubmatrix(ndi, 1, 1, npi.length/2);
        int[][]a12=getSubmatrix(npi, npi.length/2+1, 1, npi.length/2);
        int[][]b12=getSubmatrix(ndi, npi.length/2+1, 1, npi.length/2);
        int[][]a21=getSubmatrix(npi, 1, npi.length/2+1, npi.length/2);
        int[][]b21=getSubmatrix(ndi, 1, npi.length/2+1, npi.length/2);
        int[][]a22=getSubmatrix(npi, npi.length/2+1, npi.length/2+1, npi.length/2);
        int[][]b22=getSubmatrix(ndi, npi.length/2+1, npi.length/2+1, npi.length/2);
        int[][]p1=stras(a11, sub(b12,b22),blok);
        int[][]p2=stras(add(a11,a12), b22,blok);
        int[][]p3=stras(add(a21,a22),b11,blok);
        int[][]p4=stras(a22, sub(b21, b11),blok);
        int[][]p5=stras(add(a11,a22), add(b11,b22),blok);
        int[][]p6=stras(sub(a12,a22),add(b21,b22),blok);
        int[][]p7=stras(sub(a11,a21),add(b11,b12),blok);

        int[][]prvi=add(p5,add(p4,sub(p6,p2)));
        int[][]drugi=add(p1,p2);
        int[][]tretji=add(p3,p4);
        int[][]cetrti=add(sub(p1,p3),sub(p5,p7));

        for(int i=0;i<npi.length/2;i++){
            for(int j=0;j<npi.length/2;j++){
                nazaj[i][j]=prvi[i][j];
            }
        }
        for(int i=0;i<npi.length/2;i++){
            for(int j=npi.length/2;j<npi.length;j++){
                nazaj[i][j]=drugi[i][j-npi.length/2];
            }
        }
        for(int i=npi.length/2;i<npi.length;i++){
            for(int j=0;j<npi.length/2;j++){
                nazaj[i][j]=tretji[i-npi.length/2][j];
            }
        }
        for(int i=npi.length/2;i<npi.length;i++){
            for(int j=npi.length/2;j<npi.length;j++){
                nazaj[i][j]=cetrti[i-npi.length/2][j-npi.length/2];
            }
        }
        int vsota=0;
        for(int i=0;i<npi.length;i++){
            for(int j=0;j<npi.length;j++){
                vsota=vsota+nazaj[i][j];
            }
        }

        //int[][]nazaj=stras(npi,ndi,blok);
        System.out.println("DIMS: "+npi.length+"x"+npi.length);
        printM(nazaj);




    }
//********************************************************************************************************************
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String test=sc.nextLine();
        
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[][] prva= new int[a][b];
        //System.out.println("a in b: "+a+" "+b);
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                prva[i][j]=sc.nextInt();
                //System.out.println("takole: "+prva[i][j]);
            }
        }
        int c=sc.nextInt();
        int d=sc.nextInt();
        //System.out.println("c in d: "+c+" "+d);
        int[][] druga=new int[c][d];
        for(int i=0;i<c;i++){
            for(int j=0;j<d;j++){
                druga[i][j]=sc.nextInt();
                //System.out.println("takole: "+druga[i][j]);
            }
        }
        //System.out.println("****************");
        if(test.equals("os")){
            navmno(prva, druga);
        } else {
            String[] obe=test.split(" ");
            if(obe[0].equals("bl")){
                b2(prva,druga,Integer.parseInt(obe[1]));
            }
            if(obe[0].equals("dv")){
                dvlad(prva,druga,Integer.parseInt(obe[1]));
            }
            if(obe[0].equals("st")){
                str(prva, druga, Integer.parseInt(obe[1]));
            }
        }
        /*cifra c= prva.plus(druga);
        for(int i=0;i<c.num.length;i++){
            if(c.num[i]!=0){
                System.out.print(c.num[i]);
            }
        }
        System.out.println();*/
        //System.out.println(tabela[1]*tabela[2]);
        
        if(test.equals("test")){
            int[][] placilna = new int[5][5];
            placilna[0][0]=0;
            placilna[0][1]=2;
            placilna[0][2]=0;
            placilna[0][3]=1;
            placilna[0][4]=-4;
            placilna[1][0]=-2;
            placilna[1][1]=0;
            placilna[1][2]=-3;
            placilna[1][3]=1;
            placilna[1][4]=0;
            placilna[2][0]=0;
            placilna[2][1]=3;
            placilna[2][2]=0;
            placilna[2][3]=-1;
            placilna[2][4]=-2;
            placilna[3][0]=-1;
            placilna[3][1]=-1;
            placilna[3][2]=1;
            placilna[3][3]=0;
            placilna[3][4]=2;
            placilna[4][0]=4;
            placilna[4][1]=0;
            placilna[4][2]=2;
            placilna[4][3]=-2;
            placilna[4][4]=0;
            for(int i=1;i<6;i+=2){
                for(int j=1;j<6;j+=2){
                    printM(getSubmatrix(placilna, i, j, 2));
                    System.out.println("************");
                }
            }

        }



        sc.close();
    }


}