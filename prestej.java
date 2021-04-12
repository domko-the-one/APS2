import java.util.Scanner;

public class prestej {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String a=sc.nextLine();
        String[] b=a.split(" ");
        System.out.println("dolzina: "+b.length);
        sc.close();
    }

}