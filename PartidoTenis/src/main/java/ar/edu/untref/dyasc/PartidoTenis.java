package ar.edu.untref.dyasc;

public class PartidoTenis{
	
	private int puntosAnotadosJ1;
	private int puntosAnotadosJ2;
	private int puntajes[] = {0,15,30,40};
	
	public PartidoTenis() {
		this.puntosAnotadosJ1 = 0;
		this.puntosAnotadosJ2 = 0;
	}

	public int obtenerPuntaje(NumeroDeJugador numero) {
		
		if(numero == NumeroDeJugador.UNO) {
			return puntajes[puntosAnotadosJ1];
		}else {
			return puntajes[puntosAnotadosJ2];
		}
	}

	public void anotarPunto(NumeroDeJugador uno) {
		
		if(puntosAnotadosJ1 == 3) {
			puntosAnotadosJ1 = 0;
		}else if(uno == NumeroDeJugador.UNO) {
			puntosAnotadosJ1 ++;
		}else {
			puntosAnotadosJ2 ++;
		}
		
	}

	public int obtenerGames(NumeroDeJugador uno) {
		
		return 1;
	}
	

}
