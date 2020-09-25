package ar.edu.untref.dyasc;

public class Fibo {
	
	public String serieFibonacci(int cantidad) {
			
				if(cantidad <= 0) {
					return "La cantidad de terminos debe ser positiva y mayor a 0";
				}
				
				String cadena = "fibo<" +  cantidad + ">:";
				int a = 0;
				int b = 1;
				int temp = 0;
	
				for(int i=0; i<cantidad; i++) {     
					
					cadena += " " + temp; 
					a = b;
					b = temp;
					temp = a+b;  
					
				}
				return cadena;

	}
}
