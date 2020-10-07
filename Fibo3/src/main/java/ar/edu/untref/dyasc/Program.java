package ar.edu.untref.dyasc;
public class Program {

	public static void main(String[] args) {
		int[] secuencia;
				
		if (args.length == 1) { //si tengo solo un elemento calculo el fibo normal y corriente
			try {
				secuencia = Fibonacci.calcularKNumerosDeSerie(Integer.parseInt(args[0]));
				System.out.print(Fibonacci.orientacionSecuencia(secuencia, 'h')); //PONER UN SYSTEM.OUT
			} catch (Exception NumberFormatException) {
				System.out.println("Opciones no validas.");
			}
		} else if(args[0].matches("-o=[v || h][i || d]")) { //si no se establece la direcci�n y orientaci�n correcta, finalizo el programa
			
			secuencia = Fibonacci.calcularKNumerosDeSerie(Integer.parseInt(args[args.length -1])); //guardo la serie de numeros en un array
			char opcionOrientacion = args[0].charAt(3);											   //guardo la orientacion	
			char opcionDireccion = args[0].charAt(4);											   //guardo la direcci�n	
			secuencia = Fibonacci.direccionSecuencia(secuencia, opcionDireccion);                  //modifico el array estableciendo una direcci�n en caso de que sea diferente a directo
			String texto = Fibonacci.orientacionSecuencia(secuencia, opcionOrientacion);   		   //guardo la impresi�n de la secuencia la cual podre imprimir en consola o para escribir en archivo	
			
			Parametros p = new Parametros(args);
			
			if(p.modoSumar()) { //verifico si se insert� parametros para la suma de la secuencia
				texto = Fibonacci.suma(secuencia, args[args.length -2].charAt(3), opcionOrientacion); //en el caso de que haya suma guardo la suma en texto, la cual podre imprimir o escribir en un archivo 
			}
			
			if(p.escribirArchivo()) { //verifico si se insert� parametro para escribir en un archivo de salida y salgo del programa sin imprimir en consola
				Fibonacci.escribirFiboEnArchivo(texto, p.obtenerNombreArchivo());   //llamo al metodo de escribir en un archivo                   
				System.exit(1);;
			}
			System.out.print(texto);  

		} else { //si algunas de las opciones no es valida
			System.out.println("Opciones no validas.");
		}
		System.out.println();
	}
}
