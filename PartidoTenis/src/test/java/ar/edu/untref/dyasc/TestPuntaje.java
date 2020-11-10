package ar.edu.untref.dyasc;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class TestPuntaje {
	
	private PartidoTenis partido;

	@Before
	public void comenzarUnPartido() {
		partido = new PartidoTenis();
	}
	
	@Test
	public void consultarPuntoJugadoresAlIniciar() {
		Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	}
	
	@Test
	public void unJugadorUnoAnotaSuPrimerPuntoYsuma15EnElScore() {
		
		partido.anotarPunto(NumeroDeJugador.UNO);
		
		Assert.assertEquals(15, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	}
	
	@Test
	public void elJugadorUnoAnotaDosPuntosYsuma30() {
		
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		
		Assert.assertEquals(30, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	}
	
	@Test
	public void elJugadorUnoAnotaTresPuntosYsuma40() {
		
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		
		Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	}
	
	@Test
	   public void elJugadorUnoAnota4PuntosYGanaElGame() {
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        
	        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	        Assert.assertEquals(1, partido.obtenerGames(NumeroDeJugador.UNO));
	    }
	
}