package ar.edu.untref.dyasc;

public class AnotadorPuntos {
	
	private final int puntajes[] = {0,15,30,40};
	
	
	public void anotarPunto(Jugador jugQueAnotoPunto, Jugador jAdversario) {
		if(existeDeuce(jugQueAnotoPunto, jAdversario)) {
			anotarPuntoEnDeuce(jugQueAnotoPunto, jAdversario);
		}else if(jugQueAnotoPunto.getPuntaje() == 40) {
			anotaPuntoTeniendo40YNoHayDeuce(jugQueAnotoPunto,jAdversario );
		}else {
			jugQueAnotoPunto.sumarUnaAnotacion();
			jugQueAnotoPunto.setPuntaje(puntajes[jugQueAnotoPunto.getCantAnotaciones()]);
		}
	}
	
	public void anotaPuntoTeniendo40YNoHayDeuce(Jugador jugQueAnotoPunto, Jugador jAdversario) {
		
		jugQueAnotoPunto.gameGanado();
	}
	
	public boolean existeDeuce (Jugador j1, Jugador j2) {
		
		boolean resultado = (j1.getPuntaje() == 40 && j2.getPuntaje() == 40) ? true : false;
		return resultado;		
	}
	
	public void anotarPuntoEnDeuce(Jugador jugQueAnoto, Jugador adversario) {
		if(jugQueAnoto.getVentaja()) {
			jugQueAnoto.gameGanado();
		}else if(adversario.getVentaja()) {
			adversario.setVentaja(false);
		}else {
			jugQueAnoto.setVentaja(true);
		}
	}

}
