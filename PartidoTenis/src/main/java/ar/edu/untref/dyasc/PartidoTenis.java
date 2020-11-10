package ar.edu.untref.dyasc;

public class PartidoTenis{
	
	private int puntajeJugador1;
	private int puntajeJugador2;
	private int puntajes[] = {0,15,30,40};
	
	public PartidoTenis() {
		this.puntajeJugador1 = 0;
		this.puntajeJugador2 = 0;
	}

	public int obtenerPuntaje(NumeroDeJugador numero) {
		
		if(numero == NumeroDeJugador.UNO) {
			return puntajes[puntajeJugador1];
		}else {
			return puntajes[puntajeJugador2];
		}
	}

	public void anotarPunto(NumeroDeJugador uno) {
		
		if(uno == NumeroDeJugador.UNO) {
			puntajeJugador1 ++;
		}else {
			puntajeJugador2 ++;
		}
		
	}
	

}
