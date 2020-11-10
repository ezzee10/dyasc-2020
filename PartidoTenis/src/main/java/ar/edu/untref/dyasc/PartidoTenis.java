package ar.edu.untref.dyasc;

public class PartidoTenis{
	
	private int puntajeJugador1;
	private int puntajeJugador2;
	
	public PartidoTenis() {
		this.puntajeJugador1 = 0;
		this.puntajeJugador2 = 0;
	}

	public int obtenerPuntaje(NumeroDeJugador numero) {
		
		if(numero == NumeroDeJugador.UNO) {
			return puntajeJugador1;
		}else {
			return puntajeJugador2;
		}
	}

	public void anotarPunto(NumeroDeJugador uno) {
		
		if(uno == NumeroDeJugador.UNO) {
			puntajeJugador1 += 15;
		}
		
	}
	

}
