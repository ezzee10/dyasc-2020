package ar.edu.untref.dyasc;
public class Parametros {
	
	private String[] args;
	private int cantidad;
	private String nombreArchivo;
	
	public Parametros (String[] args) {
		this.args = args;
		this.cantidad = args.length;
	}
	
	public boolean escribirArchivo() {
		 for(int i=0; i<cantidad; i++) {
			 if(args[i].matches("-f=[a-zA-Z0-9]+")) {
				 this.nombreArchivo = args[i].substring(3, args[i].length());
				 return true;
			 }
		 }
		 return false;
	}
	
	public String obtenerNombreArchivo() {
		return nombreArchivo;
	}
	
	public boolean modoSumar() {
		for(int i=0; i<cantidad; i++) {
			if(args[i].matches("-m=[s || l]")) {
				return true;
			}
		}
		return false;
	}

}
