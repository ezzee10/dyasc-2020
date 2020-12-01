package ar.edu.untref.dyasc;
public class MainFibo2 {
	
	//public static void main(String args[]) {
		
		boolean horizontal;
		boolean directo;
		int cantidad;
		
		if(args.length == 2) {
			if(args[0].length() !=5 || (!args[0].equals("-o=vi") && !args[0].equals("-o=vd") && !args[0].equals("-o=hi") && !args[0].equals("-o=hd"))){
		
				System.out.print("Opciones no válidas.");
				System.exit(1);
			}
			cantidad = Integer.parseInt(args[1]);
			horizontal = args[0].substring(3, 4).equals("h");
	        directo = args[0].substring(4, 5).equals("d");

		}else {
			cantidad = Integer.parseInt(args[0]);
			horizontal = true;
			directo = true;
		}
		
		Fibo2 f = new Fibo2();
		int[] serie = f.generarSerieFibonacci(cantidad); //cantidad
		String r = f.orientacionYdireccion(serie, horizontal, directo); //serie, horizontal, directo
		System.out.print(r);
	}
}