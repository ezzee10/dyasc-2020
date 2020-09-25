package ar.edu.untref.dyasc;
public class MainFibo {

	public static void main(String[] args) {
		Fibo f = new Fibo();
		String r = f.serieFibonacci(Integer.parseInt(args[0]));
		System.out.print(r);
	}
	


}
