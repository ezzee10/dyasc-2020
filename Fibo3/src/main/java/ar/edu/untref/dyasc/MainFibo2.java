package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;

public class MainFibo2 {
	
	public static void main(String args[]) {
		
		boolean horizontal = true;
		boolean directo = true;
		boolean sumatoria = false;
		String nombreArchivo = null;
		int cantidad;
		
		if(args.length >= 2) {
			// Se declara la posición de cada parametro en el array args suponiendo que se especifican todos los parametros
			int indiceOpción = 0;
			int indiceArchivo = 1;
			int indiceModo = 2;
			int indiceCantidad = 3;
			if(args[indiceOpción].startsWith("-o")){
				if((!args[indiceOpción].equals("-o=vi") && !args[indiceOpción].equals("-o=vd") && !args[indiceOpción].equals("-o=hi") && !args[indiceOpción].equals("-o=hd"))){
					System.out.print("Opciones no válidas.");
					System.exit(1);
				}
				horizontal = args[0].substring(3, 4).equals("h");
		        directo = args[0].substring(4, 5).equals("d");
			}else {
				indiceArchivo--; 
				indiceModo--; 
				indiceCantidad--;
			}
			if(args[indiceArchivo].startsWith("-f=")){
				nombreArchivo = args[indiceArchivo].substring(3, args[indiceArchivo].length());
			}else{
				indiceModo--;
				indiceCantidad--;
			}
			if(args[indiceModo].equals("-m=s") || args[indiceModo].equals("-m=s")) {
				sumatoria = true;
			}else {
				indiceCantidad--;
			}
			cantidad = Integer.parseInt(args[indiceCantidad]);
		}else {
			cantidad = Integer.parseInt(args[0]);
			horizontal = true;
			directo = true;
		}
		
		Fibo3 f = new Fibo3();
		int[] serie = f.generarSerieFibonacci(cantidad); //cantidad
		if(sumatoria) {
			int[] resultadoSumatoria = new int[1];
			resultadoSumatoria[0] = f.realizarSumatoriaDeSerie(serie);
			serie = resultadoSumatoria;
		}
		String r = f.orientacionYdireccion(serie, horizontal, directo, sumatoria); //serie, horizontal, directo
		if(nombreArchivo != null) {
			FileWriter escritor;
			try {
				escritor = new FileWriter(nombreArchivo);
				escritor.write(r);
				escritor.close();
				System.out.println("fibo<" + cantidad +"> guardado en " + nombreArchivo);
			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo");
			}
		}else {
			System.out.println(r);
		}
		
	}
}