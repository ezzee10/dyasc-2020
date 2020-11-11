package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

public class PartidoTenis{
	
	private Map<NumeroDeJugador, Jugador> jugadores = new HashMap<NumeroDeJugador,Jugador>();
	private AnotadorPuntos anotador;
	private ControladorDeSets controladorSets;
	
	public PartidoTenis() {
		
		jugadores.put(NumeroDeJugador.UNO, new Jugador());
		jugadores.put(NumeroDeJugador.DOS, new Jugador());
		anotador = new AnotadorPuntos();
		controladorSets = new ControladorDeSets();
	}

	public int obtenerPuntaje(NumeroDeJugador numero) {
		
		Jugador j = jugadores.get(numero);
		
		return j.getPuntaje();
		 
	}

	public void anotarPunto(NumeroDeJugador numero) {
		
		Jugador jugadorQueAnoto = jugadores.get(numero);
		Jugador jugadorAdversario = null;
		
	    for (Map.Entry<NumeroDeJugador, Jugador> jugador : jugadores.entrySet()) {
	        if (jugador.getKey() != numero) {
	            jugadorAdversario = jugador.getValue();
	        }
	    }
		
		anotador.anotarPunto(jugadorQueAnoto, jugadorAdversario);
		
		if(jugadorQueAnoto.getGamesGanados() == 6) {
			System.out.print("XD");
			controladorSets.anotarSets(jugadorQueAnoto, jugadorAdversario);
		}
			
	}
	

	public int obtenerGames(NumeroDeJugador numero) {
		
		Jugador j = jugadores.get(numero);
		
		return j.getGamesGanados();
	}

	public boolean tieneVentaja(NumeroDeJugador numero) {
		
		Jugador j = jugadores.get(numero);
		
		return j.getVentaja();
	}

	public int obtenerSets(NumeroDeJugador numero) {
		
		Jugador j = jugadores.get(numero);
		
		return j.getSetsGanados();
	}
	
	public int obtenerPuntajeTieBreak(NumeroDeJugador numero) {
		return 1;
	}
	
	

}
