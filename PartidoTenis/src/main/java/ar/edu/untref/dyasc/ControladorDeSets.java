package ar.edu.untref.dyasc;

public class ControladorDeSets {
	
	public ControladorDeSets() {
		
	}
	
	public void anotarSets(Jugador jugador) {
		jugador.ganoSet();
		jugador.reiniciarScore();
		jugador.setGamesGanados(0);
	}

}
