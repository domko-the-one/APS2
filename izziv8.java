import java.util.Scanner;

public class izziv8{

    static class Complex{
        double re;
        double im;

        public Complex(double real, double imag) {
            re = real;
            im = imag;
        }

        public String toString() {
            double tRe = (double)Math.round(re * 100000) / 100000;
            double tIm = (double)Math.round(im * 100000) / 100000;
            if (tIm == 0) return tRe + "";
            if (tRe == 0) return tIm + "i";
            if (tIm <  0) return tRe + "-" + (-tIm) + "i";
            return tRe + "+" + tIm + "i";
        }

        public Complex conj() {
            return new Complex(re, -im);
        }

        // sestevanje
        public Complex plus(Complex b) {
            Complex a = this;
            double real = a.re + b.re;
            double imag = a.im + b.im;
            return new Complex(real, imag);
        }

        // odstevanje
        public Complex minus(Complex b) {
            Complex a = this;
            double real = a.re - b.re;
            double imag = a.im - b.im;
            return new Complex(real, imag);
        }

        // mnozenje z drugim kompleksnim stevilo
        public Complex times(Complex b) {
            Complex a = this;
            double real = a.re * b.re - a.im * b.im;
            double imag = a.re * b.im + a.im * b.re;
            return new Complex(real, imag);
        }

        // mnozenje z realnim stevilom
        public Complex times(double alpha) {
            return new Complex(alpha * re, alpha * im);
        }

        // reciprocna vrednost kompleksnega stevila
        public Complex reciprocal() {
            double scale = re*re + im*im;
            return new Complex(re / scale, -im / scale);
        }

        // deljenje
        public Complex divides(Complex b) {
            Complex a = this;
            return a.times(b.reciprocal());
        }

        // e^this
        public Complex exp() {
            return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
        }


        //potenca komplesnega stevila
        public Complex pow(int k) {

            Complex c = new Complex(1,0);
            for (int i = 0; i <k ; i++) {
                c = c.times(this);
            }
            return c;
        }
    }

    public static boolean istwo(int n) {
        return n>0 && (n&n-1)==0;
    }

    public static Complex[] fft(Complex[] pol){
        int n= pol.length;
        Complex[] nazaj = new Complex[n*2];
        if(n==1){
            System.out.println(pol[0].toString()+" "+pol[0].toString());
            return new Complex[] {pol[0], pol[0]};
        }
        
        Complex[] soda = new Complex[n/2];
        for(int i=0;i<n/2;i++){
            soda[i]=pol[2*i];
        }
        Complex[] sodafft=fft(soda);

        Complex[] liha=soda;
        for(int i=0;i<n/2;i++){
            liha[i]=pol[2*i+1];
        }
        Complex[] lihafft=fft(liha);

        for(int i=0;i<n;i++){
            double kth=2*i*Math.PI/n/2;
            Complex wk = new Complex(Math.cos(kth),Math.sin(kth));
            //System.out.println("kth: "+kth+" wk: "+wk);
            nazaj[i] = sodafft[i].plus(wk.times(lihafft[i]));
            nazaj[i+n]= sodafft[i].minus(wk.times(lihafft[i]));
        }
        for(int i=0;i<n*2;i++){
            System.out.print(nazaj[i].toString()+" ");
        }
        System.out.println();


        return nazaj;
    }

    public static Complex[] fftinverz(Complex[] pol){
        int n= pol.length;
        Complex[] nazaj = new Complex[n*2];
        if(n==1){
            //System.out.println(pol[0].toString()+" "+pol[0].toString());
            return new Complex[] {pol[0]};
        }
        
        Complex[] soda = new Complex[n/2];
        for(int i=0;i<n/2;i++){
            soda[i]=pol[2*i];
        }
        Complex[] sodafft=fftinverz(soda);

        Complex[] liha=soda;
        for(int i=0;i<n/2;i++){
            liha[i]=pol[2*i+1];
        }
        Complex[] lihafft=fftinverz(liha);

        for(int i=0;i<n/2;i++){
            double kth=-2*i*Math.PI/n;
            Complex wk = new Complex(Math.cos(kth),Math.sin(kth));
            //System.out.println("kth: "+kth+" wk: "+wk);
            nazaj[i] = sodafft[i].plus(wk.times(lihafft[i]));
            nazaj[i+n]= sodafft[i].minus(wk.times(lihafft[i]));
        }
        for(int i=0;i<n/2;i++){
            System.out.print(nazaj[i].toString()+" ");
        }
        System.out.println();


        return nazaj;
    }

    public static Complex[] ffti(Complex[] x){
        int n = x.length;

        // base case
        if (n == 1) {
            System.out.println(x[0]);
            return new Complex[] { x[0] };
        }
        
        // compute FFT of even terms
        Complex[] even = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] evenFFT = ffti(even);

        // compute FFT of odd terms
        Complex[] odd  = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] oddFFT = ffti(odd);

        // combine
        Complex[] y = new Complex[n];
        for (int k = 0; k < n/2; k++) {
            double kth = 2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k]       = evenFFT[k].plus (wk.times(oddFFT[k]));
            y[k + n/2] = evenFFT[k].minus(wk.times(oddFFT[k]));
        }
        for(int i=0;i<y.length;i++){
            System.out.print(y[i].toString()+" ");
        }
        System.out.println();
        return y;
    }

    public static Complex[] inverz(Complex[] x){
        int n=x.length;
        if(n==1){
            return x;
        }
        Complex[] even = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = new Complex(0,0).plus(x[2*k]);
        }
        Complex[] ys = inverz(even);

        Complex[] odd  = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            odd[k] = new Complex(0,0).plus(x[2*k + 1]);
        }
        Complex[] yl = inverz(odd);
        //double nnn=n;
        /*Complex dva=new Complex(-2, 0);
        Complex piii=new Complex(Math.PI,0);
        Complex iii=new Complex(0,1);
        Complex nn=new Complex(1/nnn,0);
        Complex wms=dva.times(piii).times(iii).times(nn);
        Complex w=wms.exp();*/
        Complex w=new Complex(0, -Math.PI * 2 / n).exp();
        Complex wk=new Complex(1,0);
        Complex[] y=new Complex[n];
        for(int i=0;i<n;i++){
            y[i]= new Complex(0,0);
        }
        for(int k=0;k<n/2;k++){
            y[k]=y[k].plus(ys[k].plus(wk.times(yl[k])));
            y[k+n/2]=y[k+n/2].plus(ys[k].minus(wk.times(yl[k])));
            wk=wk.times(w);
        } 
        for(int i=0;i<n;i++){
            System.out.print(y[i].toString()+" ");
        }
        System.out.println();
        return y;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dolz = sc.nextInt();
        int n=dolz;
        if(!istwo(dolz)){

            while(!istwo(n)){
                n++;
            }
        }
        Complex[] pol1= new Complex[n];
        Complex[] pol2= new Complex[n];
        
        for(int i=0;i<dolz;i++){
            pol1[i]= new Complex(sc.nextInt(),0);
            
        }
        for(int i=dolz;i<n;i++){
            pol1[i]=new Complex(0,0);
        }
        for(int i=0;i<dolz;i++){
            pol2[i]= new Complex(sc.nextInt(),0);
            
        }
        for(int i=dolz;i<n;i++){
            pol2[i]=new Complex(0,0);
        }
        //System.out.println("*******************");
        Complex[] prvi= fft(pol1);
        //System.out.println("*******************");
        Complex[] drugi=fft(pol2);
        Complex[] vmes=new Complex[prvi.length];
        for(int i=0;i<prvi.length;i++){
            vmes[i]=prvi[i].times(drugi[i]);
            //System.out.print(vmes[i].toString()+" ");
        }
        //System.out.println();
        //System.out.println("*******************");
        Complex[] izpis = inverz(vmes);
        for(int i=0;i<izpis.length;i++){
            System.out.print(izpis[i].times(1/(double)izpis.length).toString()+" ");
        }
        System.out.println();
        /*Complex aa=new Complex(1,0);
        Complex bb=new Complex(2,0);
        Complex cc=new Complex(0,0);
        Complex[] test={aa,bb,aa,cc};
        ffti(test);
        */


        sc.close();
    }


}