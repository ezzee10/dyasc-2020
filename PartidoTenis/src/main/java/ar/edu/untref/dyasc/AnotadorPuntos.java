package ar.edu.untref.dyasc;

public class AnotadorPuntos {
	
	private final int puntajes[] = {0,15,30,40};
	
	
	public void anotarPunto(Jugador jugQueAnotoPunto, Jugador jAdversario) {
		if(existeDeuce(jugQueAnotoPunto, jAdversario)) {
			anotarPuntoEnDeuce(jugQueAnotoPunto);
		}else if(jugQueAnotoPunto.getPuntaje() == 40) {
			anotaPuntoTeniendo40YNoHayDeuce(jugQueAnotoPunto,jAdversario );
		}else {
			jugQueAnotoPunto.sumarUnaAnotacion();
			jugQueAnotoPunto.setPuntaje(puntajes[jugQueAnotoPunto.getCantAnotaciones()]);
		}
	}
	
	public void anotaPuntoTeniendo40YNoHayDeuce(Jugador jugQueAnotoPunto, Jugador jAdversario) {
		jugQueAnotoPunto.gameGanado();
		jugQueAnotoPunto.reiniciarScore();
		jAdversario.reiniciarScore();
	}
	
	public boolean existeDeuce (Jugador j1, Jugador j2) {
		
		boolean resultado = (j1.getPuntaje() == 40 && j2.getPuntaje() == 40) ? true : false;
		
		return resultado;
			
	}
	
	public void anotarPuntoEnDeuce(Jugador j) {
		j.setVentaja(true);
	}

}
