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
            String to=this.val;
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

    public static void osnovno(cifra prva,cifra druga){
        char[] test=new char[3];
        
        for(int j=0;j<druga.num.length;j++){
            cifra c=new cifra(test,prva.baza);
            for(int i=0;i<druga.basetodec(j);i++){
                c=c.plus(prva);
            }
            
            if(c.num[c.num.length-1]==0){
                System.out.print("0");
            } else {
                for(int i=0;i<c.num.length;i++){
                    System.out.print(c.num[i]);
                }
            }
            System.out.println();
        }
        cifra c=new cifra(test,prva.baza);
        for(int i=0;i<druga.convertToDecimal(druga.num, druga.baza);i++){
            c=c.plus(prva);
        }
        for(int i=0;i<c.num.length;i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i=0;i<c.num.length;i++){
            System.out.print(c.num[i]);
        }
        System.out.println();
    }

    public static cifra dinv(cifra prva, cifra druga){
        //System.out.println("Kaj je na zacetku: "+new String(prva.num)+" "+new String(druga.num));
        /*if(prva.num.length%2==1&&(prva.num[0]==0||prva.num[0]==48)&&(druga.num[0]==0||druga.num[0]==48)){
            char[] zap=new char[prva.num.length-1];
            char[] zad=new char[prva.num.length-1];
            for(int i=1;i<prva.num.length;i++){
                zap[i-1]=prva.num[i];
                zad[i-1]=druga.num[i];
            }
            prva.num=zap;
            druga.num=zad;
        }*/
        String te1=new String(prva.num);
        String te2=new String(druga.num);
        while(te1.charAt(0)=='0'){
            te1=te1.substring(1);
            if(te1.length()==1){
                break;
            }
        }
        while(te2.charAt(0)=='0'){
            te2=te2.substring(1);
            if(te2.length()==1){
                break;
            }
        }
        System.out.println(te1+" "+te2);
        if(te1.length()==1||te2.length()==1){
            if(te1.charAt(0)!='0'&&te2.charAt(0)!='0'){
                //System.out.println("uporablja ta glupi del: "+te1+" "+te2);
                prva.num=te1.toCharArray();
                druga.num=te2.toCharArray();



                bigBoi str=new bigBoi(new String(prva.num), prva.baza);
                bigBoi str2=new bigBoi(new String(druga.num), druga.baza);
                cifra vmes=new cifra(str.times(str2).val.toCharArray(),prva.baza);

                //System.out.println("tukaj!");
                //cifra vmes=prva.times(druga);
                String izpis=new String(vmes.num);
                while(izpis.charAt(0)=='0'){
                    izpis=izpis.substring(1);
                    if(izpis.length()==1){
                        break;
                    }
                }
                System.out.println(izpis);
                //System.out.println("return vmes");
                return vmes;
            } else if(te1.charAt(0)=='0'||te2.charAt(0)=='0'){
                char[] nekaj=new char[1];
                nekaj[0]='0';
                System.out.println("0");
                return new cifra(nekaj,prva.baza);
            }
        }
        int l1=te1.length();
        int l2=te2.length();
        if(l1>l2){
            if(l1%2==1){
                te1="0"+te1;
                for(int i=0;i<l1-l2+1;i++){
                    te2="0"+te2;
                }
            } else{
                for(int i=0;i<l1-l2;i++){
                    te2="0"+te2;
                }
            }
        } else if(l1<l2){
            if(l2%2==1){
                te2="0"+te2;
                for(int i=0;i<l2-l1+1;i++){
                    te1="0"+te1;
                }
            } else {
                for(int i=0;i<l2-l1;i++){
                    te1="0"+te1;
                }
            }
        } else if(l1==l2){
            if(l1%2==1){
                te1="0"+te1;
                te2="0"+te2;
            }
        }
        prva.num=te1.toCharArray();
        druga.num=te2.toCharArray();

        int mult=1;
        char[] test = new char[1];

        cifra a=new cifra(test,prva.baza);
        cifra b=new cifra(test,prva.baza);
        cifra c=new cifra(test,prva.baza);
        cifra d=new cifra(test,prva.baza);
        //System.out.println("te1 in te2: "+te1+" "+te2);
        if(prva.num.length<druga.num.length){
            
            if(druga.num.length%2==1){
                mult=druga.num.length+1;
                //System.out.println("druga liha: +1");
            } else {
                mult=druga.num.length;
                //System.out.println("druga soda: 0");
            }
        } else {
            if(prva.num.length%2==1){
                mult=prva.num.length+1;
                //System.out.println("prva liha: +1");
            } else {
                mult=prva.num.length;
                //System.out.println("prva soda: 0");
            }
        }
        //System.out.println("mult: "+mult);
        String ti1=new String(prva.num);
        String ti2=new String(druga.num);
        while(ti1.length()<mult){
            ti1="0"+ti1;
        }
        while(ti2.length()<mult){
            ti2="0"+ti2;
        }
        prva.num=ti1.toCharArray();
        druga.num=ti2.toCharArray();

        char[] nov1=new char[mult/2];
        char[] nov2=new char[mult/2];
        char[] nov3=new char[mult/2];
        char[] nov4=new char[mult/2];
        
        for(int i=0;i<mult/2;i++){
            nov1[i]=prva.num[i];
            nov2[i]=druga.num[i];
        }
        for(int i=mult/2;i<mult;i++){
            nov3[i-mult/2]=prva.num[i];
            nov4[i-mult/2]=druga.num[i];
        }
        //System.out.println("razdelil takole: "+new String(nov1)+" "+new String(nov3)+" in "+new String(nov2)+" "+new String(nov4));
        a.num=nov1;
        b.num=nov3;
        c.num=nov2;
        d.num=nov4;


        
        //System.out.println("[dinv]bd: "+new String(b.num)+" "+new String(d.num));
        cifra bd=dinv(b, d);
        //System.out.println("[dinv]bc: "+new String(b.num)+" "+new String(c.num));
        cifra bc=dinv(b, c);
        //System.out.println("[dinv]ad: "+new String(a.num)+" "+new String(d.num));
        cifra ad=dinv(a, d);
        //System.out.println("[dinv]ac: "+new String(a.num)+" "+new String(c.num));
        cifra ac=dinv(a, c);
        
        
        String des="1";
        String des2="1";
        for(int i=0;i<mult;i++){
            des=des+"0";
        }
        for(int i=0;i<mult/2;i++){
            des2=des2+"0";
        }
        bigBoi str=new bigBoi(new String(bd.num), prva.baza);
        bigBoi str2=new bigBoi(new String(bc.num), druga.baza);
        bigBoi str3=new bigBoi(new String(ad.num), prva.baza);
        bigBoi str4=new bigBoi(new String(ac.num), druga.baza);
        bigBoi de=new bigBoi(new String(des), prva.baza);
        bigBoi de2=new bigBoi(new String(des2), druga.baza);
        /*System.out.print("bd: ");
        for(int i=0;i<bd.num.length;i++){
            System.out.print(bd.num[i]);
        }
        System.out.println();
        System.out.print("bc: ");
        for(int i=0;i<bc.num.length;i++){
            System.out.print(bc.num[i]);
        }
        System.out.println();
        System.out.print("ad: ");
        for(int i=0;i<ad.num.length;i++){
            System.out.print(ad.num[i]);
        }
        System.out.println();
        System.out.print("ac: ");
        for(int i=0;i<ac.num.length;i++){
            System.out.print(ac.num[i]);
        }
        System.out.println();
        System.out.print("deset: ");
        for(int i=0;i<deset.num.length;i++){
            System.out.print(deset.num[i]);
        }
        System.out.println();
        System.out.print("des2: ");
        for(int i=0;i<des2.num.length;i++){
            System.out.print(des2.num[i]);
        }
        System.out.println();*/
        //cifra nazaj= bd.plus(ac.times(deset).plus(bc.plus(ad).times(des2)));
        bigBoi nazaj=str.add(str4.times(de).add(str2.add(str3).times(de2)));
        cifra vmes=new cifra(nazaj.val.toCharArray(),prva.baza);
        //System.out.println(nazaj.num.toString());
        String izpis=nazaj.val;
        while(izpis.charAt(0)=='0'){
            izpis=izpis.substring(1);
        }
        System.out.println(izpis);
        
        //System.out.println("return nazaj");
        return vmes;
        
        

    }

    public static cifra kara(cifra prva, cifra druga){
        //System.out.println("Kaj je na zacetku: "+new String(prva.num)+" "+new String(druga.num));
        String te1=new String(prva.num);
        String te2=new String(druga.num);
        while(te1.charAt(0)=='0'&&te1.length()>1){
            te1=te1.substring(1);
            if(te1.length()==1){
                break;
            }
        }
        while(te2.charAt(0)=='0'&&te2.length()>1){
            te2=te2.substring(1);
            if(te2.length()==1){
                break;
            }
        }
        System.out.println(te1+" "+te2);
        if(te1.length()==1||te2.length()==1){
            if(te1.charAt(0)!='0'&&te2.charAt(0)!='0'){
                //System.out.println("uporablja ta glupi del: "+te1+" "+te2);
                prva.num=te1.toCharArray();
                druga.num=te2.toCharArray();



                bigBoi str=new bigBoi(new String(prva.num), prva.baza);
                bigBoi str2=new bigBoi(new String(druga.num), druga.baza);
                cifra vmes=new cifra(str.times(str2).val.toCharArray(),prva.baza);

                //System.out.println("tukaj!");
                //cifra vmes=prva.times(druga);
                String izpis=new String(vmes.num);
                while(izpis.charAt(0)=='0'){
                    izpis=izpis.substring(1);
                    if(izpis.length()==1){
                        break;
                    }
                }
                System.out.println(izpis);
                //System.out.println("return vmes");
                return vmes;
            } else if(te1.charAt(0)=='0'||te2.charAt(0)=='0'){
                char[] nekaj=new char[1];
                nekaj[0]='0';
                System.out.println("0");
                return new cifra(nekaj,prva.baza);
            }
        }
        int l1=te1.length();
        int l2=te2.length();
        if(l1>l2){
            if(l1%2==1){
                te1="0"+te1;
                for(int i=0;i<l1-l2+1;i++){
                    te2="0"+te2;
                }
            } else{
                for(int i=0;i<l1-l2;i++){
                    te2="0"+te2;
                }
            }
        } else if(l1<l2){
            if(l2%2==1){
                te2="0"+te2;
                for(int i=0;i<l2-l1+1;i++){
                    te1="0"+te1;
                }
            } else {
                for(int i=0;i<l2-l1;i++){
                    te1="0"+te1;
                }
            }
        } else if(l1==l2){
            if(l1%2==1){
                te1="0"+te1;
                te2="0"+te2;
            }
        }
        prva.num=te1.toCharArray();
        druga.num=te2.toCharArray();
        //System.out.println("pripravljen za delo: "+te1+" in "+te2);

        int mult=1;
        char[] test = new char[1];
        /*
        int pis1=0;
        int pis2=0;
        for(pis1=0;pis1<prva.num.length;pis1++){
            if(prva.num[pis1]!=48){
                break;
            }
        }
        for(int i=pis1;i<prva.num.length;i++){
            System.out.print(prva.num[i]);
        }
        System.out.print(" ");
        for(pis2=0;pis2<druga.num.length;pis2++){
            if(druga.num[pis2]!=48){
                break;
            }
        }
        for(int i=pis2;i<druga.num.length;i++){
            System.out.print(druga.num[i]);
        }
        System.out.println();*/
        cifra a=new cifra(test,prva.baza);
        cifra b=new cifra(test,prva.baza);
        cifra c=new cifra(test,prva.baza);
        cifra d=new cifra(test,prva.baza);
    
        mult=prva.num.length;
        char[] nov1=new char[mult/2];
        char[] nov2=new char[mult/2];
        char[] nov3=new char[mult/2];
        char[] nov4=new char[mult/2];
        
        for(int i=0;i<mult/2;i++){
            nov1[i]=prva.num[i];
            nov2[i]=druga.num[i];
        }
        for(int i=mult/2;i<mult;i++){
            nov3[i-mult/2]=prva.num[i];
            nov4[i-mult/2]=druga.num[i];
        }
        a.num=nov1;
        b.num=nov3;
        c.num=nov2;
        d.num=nov4;
    
        
        cifra bd=kara(b, d);
        
        cifra ac=kara(a, c);
        bigBoi sa=new bigBoi(new String(a.num), prva.baza);
        bigBoi sb=new bigBoi(new String(b.num), prva.baza);
        bigBoi sc=new bigBoi(new String(c.num), prva.baza);
        bigBoi sd=new bigBoi(new String(d.num), prva.baza);
        cifra zm=kara(new cifra(sa.add(sb).val.toCharArray(),prva.baza),new cifra(sd.add(sc).val.toCharArray(),prva.baza));
        String des="1";
        String des2="1";
        for(int i=0;i<mult;i++){
            des=des+"0";
        }
        for(int i=0;i<mult/2;i++){
            des2=des2+"0";
        }
        bigBoi de=new bigBoi(new String(des), prva.baza);
        bigBoi de2=new bigBoi(new String(des2), druga.baza);
        bigBoi str=new bigBoi(new String(bd.num), prva.baza);
        bigBoi str2=new bigBoi(new String(ac.num), prva.baza);
        bigBoi str3=new bigBoi(new String(zm.num), prva.baza);
        cifra nazaj=new cifra((str2.times(de).add((str3.minus(str).minus(str2)).times(de2)).add(str)).val.toCharArray(),prva.baza);
        //cifra nazaj=ac.times(deset).plus((zm.minus(bd).minus(ac)).times(des2)).plus(bd);
        String izpis=new String(nazaj.num);
        while(izpis.charAt(0)=='0'){
            izpis=izpis.substring(1);
        }
        System.out.println(izpis);
        return nazaj;
        
    }
    
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String test=sc.nextLine();
        int baza=Integer.valueOf(sc.nextLine());
        String a=sc.nextLine();
        String b=sc.nextLine();
        cifra prva=new cifra(a.toCharArray(),baza);
        cifra druga=new cifra(b.toCharArray(),baza);

        
        /*cifra c= prva.plus(druga);
        for(int i=0;i<c.num.length;i++){
            if(c.num[i]!=0){
                System.out.print(c.num[i]);
            }
        }
        System.out.println();*/
        //System.out.println(tabela[1]*tabela[2]);
        if(test.equals("os")){
            osnovno(prva, druga);
        } else if(test.equals("dv")){
            int zakaj=a.length();
            int zakaj2=b.length();
            if(zakaj>zakaj2){
                for(int i=0;i<zakaj-zakaj2;i++){
                    b="0"+b;
                }
                druga.num=b.toCharArray();
            } else if(zakaj<zakaj2){
                for(int i=0;i<zakaj2-zakaj;i++){
                    a="0"+a;
                }
                prva.num=a.toCharArray();
            }
            cifra c=dinv(prva, druga);
        } else if(test.equals("ka")){
            int zakaj=a.length();
            int zakaj2=b.length();
            if(zakaj>zakaj2){
                for(int i=0;i<zakaj-zakaj2;i++){
                    b="0"+b;
                }
                druga.num=b.toCharArray();
            } else if(zakaj<zakaj2){
                for(int i=0;i<zakaj2-zakaj;i++){
                    a="0"+a;
                }
                prva.num=a.toCharArray();
            }
            cifra c=kara(prva, druga);
        } else if(test.equals("test")){
            bigBoi n=new bigBoi("413", 10);
            bigBoi m=new bigBoi("123", 10);
            bigBoi e=new bigBoi("23", 10);
            bigBoi des=new bigBoi("10", 10);
            bigBoi dev=new bigBoi("9", 10);
            bigBoi ose=new bigBoi("8", 10);
            System.out.println(n.add(m).val);
            System.out.println(n.times(m).val);
            System.out.println(n.minus(m).val);
            System.out.println(n.minus(e).val);
            System.out.println(des.minus(dev).val);
            System.out.println(dev.minus(ose).val);
        }



        sc.close();
    }


}