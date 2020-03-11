package Detyra;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigDecimal;
public class Probabiliteti {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Jepni numrin e userave te kycur ne link: ");
		int n=input.nextInt();
		System.out.print("Jepni numrin e userave qe jane aktiv ne te njejten kohe: ");
		int k=input.nextInt();
		BigDecimal a=FSHPB(n,k);
		System.out.printf("%s%d%s%.4f%n","Probabiliteti qe me shume se ", (k-1), " usera te jene aktiv ne te njejten kohe eshte: ",a);
		BigDecimal b = BigDecimal.ONE.subtract(a);
		System.out.printf("%s%d%s%.4f", "Ne rastin kur aktiv jane ", (k-1), " apo me pak usera: ", b);
		input.close();
	}
	
	public static BigDecimal FSHPB(int n, int k) {
		BigDecimal a=BigDecimal.ZERO;
		for(int i=k; i<=n; i++) {
			a=a.add(SHPB(n,i));
		}
		return a;
	}
	
	public static BigDecimal SHPB(int n, int k) {
			double b=(Math.pow(0.1,k))*(Math.pow(0.9,(n-k)));
			BigDecimal a=(kombinacione(n,k).multiply(BigDecimal.valueOf(b)));
		return a;
	}
	
	public static BigDecimal kombinacione(int n, int k) {
		return faktoriel(n,0).divide((faktoriel(k,0).multiply(faktoriel(n,k))));
	}
	
	public static BigDecimal faktoriel(int n, int k) {
		int a=n-k;
		BigDecimal rezulati = BigDecimal.ONE;
		for(int i=1; i<=a; i++) {
			rezulati=rezulati.multiply(new BigDecimal(i+""));
		}
		return rezulati;
	}
}

