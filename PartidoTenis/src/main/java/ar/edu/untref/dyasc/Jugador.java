package ar.edu.untref.dyasc;

public class Jugador {
	
	private int puntaje;
	private int cantPuntosAnotados;
	private int games;
	private int setsGanados;
	private int puntosTieBreak;
	private boolean ventaja;
	private boolean ganador;
	
	public Jugador() {
		this.puntaje = 0;
		this.ventaja = false;
		this.games = 0;
		this.cantPuntosAnotados = 0;
		this.puntosTieBreak = 0;
		this.ganador = false;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public void setVentaja(boolean ventaja) {
		this.ventaja = ventaja;
	}
	
	public boolean getVentaja() {
		return ventaja;
	}
	
	public void sumarUnaAnotacion() {
		cantPuntosAnotados++;
	}
	
	public int getCantAnotaciones() {
		return cantPuntosAnotados;
	}
	
	public int getGamesGanados() {
		return games;
	}
	
	public void reiniciarGamesGanados() {
		games = 0;
	}
	
	public void gameGanado() {
		games++;
	}
	
	public void reiniciarScore() {
		cantPuntosAnotados = 0;
		puntaje = 0;
		ventaja = false;
		puntosTieBreak = 0;
	}
	
	public int getSetsGanados() {
		return setsGanados;
	}

	public void ganoSet() {
		
		setsGanados++;
		
		if(setsGanados == 3) {
			ganador = true;
		}
	}
	
	public int getPuntosTieBreak() {
		return puntosTieBreak;
	}
	
	public void agregarPuntoTieBreak() {
		puntosTieBreak++;
	}
	
	public boolean esGanador() {
		return ganador;
	}
	
	public void cambiarEstadoGanador() {
		ganador = !ganador;
	}
	

	
	
	
	
	
	
	

}
