package ar.edu.untref.dyasc;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
	
	public static int[] direccionSecuencia(int secuencia[], char opcion) {
		if(opcion == 'i') {
			int[] resultado = new int[secuencia.length];
			for(int i = 0; i < secuencia.length; i++){
				resultado[i] = secuencia[(secuencia.length - i) - 1];
			}
			return resultado;
		}else{
			return secuencia;
		}
	}
	
	public static String orientacionSecuencia(int secuencia[], char opcion) {
		String resultado = "fibo<" + secuencia.length + ">: ";
		if(opcion == 'h') {
			for(int i = 0; i < secuencia.length; i++) {
				resultado += secuencia[i] + " ";
			}
		}else if(opcion == 'v') {
			for(int i = 0; i < secuencia.length; i++) {
				resultado += "\n" +secuencia[i];
			}
		}
		return resultado;
	}
	
	public static int[] calcularKNumerosDeSerie(int k){
		int[] secuenciaFinal = new int[k];
		int resultadoActual = 1;
		int resultadoAnterior = 0;
		for(int i = 0; i < k; i++) {
			if(i <= 1) {
				secuenciaFinal[i] = i; //System.out.print(resultadoAnterior + i + " ");
			}else{
				int resultadoAnteriorAuxiliar = resultadoAnterior;
				secuenciaFinal[i] = resultadoActual + resultadoAnterior; //System.out.print(resultadoActual + resultadoAnterior + " ");
				resultadoAnterior = resultadoActual;
				resultadoActual += resultadoAnteriorAuxiliar;
			}
		}
		return secuenciaFinal;
	}
	
	public static String suma(int secuencia[], char modo, char orientacion) {
		
		if(modo == 'l') {
			return orientacionSecuencia(secuencia, orientacion);
		}else {
			int suma = 0;
			String resultado = "fibo<" + secuencia.length + ">s: ";
			for(int i=0; i<secuencia.length; i++) {
				suma+= secuencia[i];
			}
			if(orientacion == 'h') {
				return resultado += suma;
			}else {
				return resultado += "\n" + suma;
			}
			
		}
	}
	
	public static void escribirFiboEnArchivo(String texto, String nombreArchivo) {

		System.out.print(texto.substring(0, 6)+ ">: guardado en "+ nombreArchivo);
		try {
			FileWriter filew = new FileWriter(nombreArchivo);
			filew.write(texto);
			filew.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
