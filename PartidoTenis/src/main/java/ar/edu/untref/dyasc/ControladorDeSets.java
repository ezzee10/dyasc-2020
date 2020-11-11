package ar.edu.untref.dyasc;

public class ControladorDeSets {
	

	public void anotarSets(Jugador jugadorQueAnota, Jugador adversario) {
		
		if(existeTieBreak(jugadorQueAnota, adversario)) {
			puntoAnotadoEnTieBreak(jugadorQueAnota);
			System.out.println("Entro alguna vez aca?");
		}else if(existeDiferenciaDeDos(jugadorQueAnota, adversario)) {
			System.out.println(jugadorQueAnota.getGamesGanados());
			System.out.println(adversario.getGamesGanados());
			jugadorQueAnota.ganoSet();
			jugadorQueAnota.reiniciarScore();
			jugadorQueAnota.setGamesGanados(0);
			adversario.reiniciarScore();
			adversario.setGamesGanados(0);
			 
		}
	}
	
	public boolean existeTieBreak(Jugador j1, Jugador j2) {
		
		boolean respuesta = (j1.getGamesGanados() == 6 &&  j2.getGamesGanados() == 6) ? true : false;
			
		return respuesta;
		
	}

	
	public void puntoAnotadoEnTieBreak(Jugador j1) {
		j1.agregarPuntoTieBreak();
	}
	
	public boolean existeDiferenciaDeDos(Jugador j1, Jugador j2) {
		
		boolean respuesta = (j1.getGamesGanados() - j2.getGamesGanados() >= 2) ? true : false;
		
		return respuesta;
	}

}
