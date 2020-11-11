package ar.edu.untref.dyasc;

public class ControladorDeSets {
	
	
	public void anotarSetsSinTieBreak(Jugador jugadorQueAnota, Jugador adversario) {
					
			if(existeDiferenciaDeDos(jugadorQueAnota, adversario)) {
			jugadorQueAnota.ganoSet();
			jugadorQueAnota.reiniciarScore();
			jugadorQueAnota.reiniciarGamesGanados();
			adversario.reiniciarScore();
			adversario.reiniciarGamesGanados();
			 
		}
	}
	
	public boolean existeTieBreak(Jugador j1, Jugador j2) {
		
		boolean respuesta = (j1.getGamesGanados() == 6 &&  j2.getGamesGanados() == 6) ? true : false;
			
		return respuesta;
		
	}

	
	public void puntoAnotadoEnTieBreak(Jugador j1) {
		
		j1.agregarPuntoTieBreak();
		
		if (j1.getPuntosTieBreak() == 7) {
			j1.ganoSet();
			j1.reiniciarScore();
			j1.reiniciarGamesGanados();
		}
		
		
	}
	
	
	public boolean existeDiferenciaDeDos(Jugador j1, Jugador j2) {
		
		boolean respuesta = (j1.getGamesGanados() - j2.getGamesGanados() >= 2) ? true : false;
		
		return respuesta;
	}

}
