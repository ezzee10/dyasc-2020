package ar.edu.untref.dyasc;
public class Fibo3 {
	
	public int[] generarSerieFibonacci(int cantidad) {
		
		if(cantidad <= 0) {
			throw new Error("La cantidad de terminos debe ser positiva y mayor a 0");
		}
		
		int[] resultado = new int[cantidad];
		int a = 0;
		int b = 1;
		int temp = 0;

		for(int i=0; i<cantidad; i++) {     
			
			resultado[i] = temp; 
			a = b;
			b = temp;
			temp = a+b;  
			
		}
		return resultado;
}
	
	public String orientacionYdireccion(int[]serie, boolean horizontal, boolean directo, boolean esSumatoria) {
		
		String cadena = "fibo<" +  serie.length + ">";
		if(esSumatoria) {
			cadena += "s";
		}
		cadena += ":";
		String espaciado;
		
		if(horizontal) {
			espaciado = " ";
		}else {
			espaciado = "\n";
		}
		if(directo) {
			for(int i=0; i<serie.length; i++) {
				cadena += espaciado + serie[i];
			}	
		}else {
			for(int i=serie.length -1; i>=0; i--) {
				cadena += espaciado + serie[i];
			}
		}
		
		return cadena;
	}
	
	public int realizarSumatoriaDeSerie(int[] serie) {
		int resultado = 0;
		for(int i = 0; i < serie.length; i++) {
			resultado += serie[i];
		}
		return resultado;
	}
}
