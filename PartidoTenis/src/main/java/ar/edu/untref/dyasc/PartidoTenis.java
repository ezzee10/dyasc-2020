package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

public class PartidoTenis{
	
	private Map<NumeroDeJugador, Jugador> jugadores = new HashMap<NumeroDeJugador,Jugador>();
	private AnotadorPuntos anotador;
	
	public PartidoTenis() {
		
		jugadores.put(NumeroDeJugador.UNO, new Jugador());
		jugadores.put(NumeroDeJugador.DOS, new Jugador());
		anotador = new AnotadorPuntos();
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
			
	}
	
	public boolean existeDeuce () {
		
		boolean resultado = true;
		
		for (Map.Entry<NumeroDeJugador, Jugador> jugador : jugadores.entrySet()) {
	        if (jugador.getValue().getPuntaje() != 40) {
	        	resultado = false;
	        }
	    }
		
		return resultado;
			
	}

	public int obtenerGames(NumeroDeJugador numero) {
		
		Jugador j = jugadores.get(numero);
		
		return j.getGamesGanados();
	}

	public boolean tieneVentaja(NumeroDeJugador numero) {
		
		Jugador j = jugadores.get(numero);
		
		return j.getVentaja();
	}

}
