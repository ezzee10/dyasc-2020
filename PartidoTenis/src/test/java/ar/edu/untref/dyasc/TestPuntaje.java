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
	
	@Test
	public void elJugadorDosAnota4PuntosYGanaElGame() {
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        
	        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	        Assert.assertEquals(1, partido.obtenerGames(NumeroDeJugador.DOS));
	}
	
	@Test
	public void existeDeuceYElJugadorUnoAnotaUnPuntoTeniendoVentaja() {
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        
	        Assert.assertEquals(true, partido.tieneVentaja(NumeroDeJugador.UNO));
	        Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
	    }
	
	@Test
	public void existeDeuceYElJugadorDosAnotaUnPuntoTeniendoVentaja() {
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        
	        Assert.assertEquals(true, partido.tieneVentaja(NumeroDeJugador.DOS));
	        Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
	    }
	
	@Test
	public void elJugadorConVentajaAnotaPuntoYGanaElGame() {
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        
	        Assert.assertEquals(false, partido.tieneVentaja(NumeroDeJugador.DOS));
	        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	        Assert.assertEquals(1, partido.obtenerGames(NumeroDeJugador.DOS));
	    }
	
	@Test
	public void elJugadorConVentajaPierdeLaVentaja() {
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        
	        Assert.assertEquals(false, partido.tieneVentaja(NumeroDeJugador.DOS));
	        Assert.assertEquals(false, partido.tieneVentaja(NumeroDeJugador.UNO));
	        Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	        Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
	        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
	    }
	
	@Test
	public void elJugadorConVentajaPierdeLaVentajaYlaRecuperaYganaGame() {
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.UNO);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        partido.anotarPunto(NumeroDeJugador.DOS);
	        
	        Assert.assertEquals(false, partido.tieneVentaja(NumeroDeJugador.DOS));
	        Assert.assertEquals(false, partido.tieneVentaja(NumeroDeJugador.UNO));
	        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
	        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	        Assert.assertEquals(1, partido.obtenerGames(NumeroDeJugador.DOS));
	        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
	    }
	
	@Test
	public void unJugadorGana2Games() {
		
			for(int i=0; i<8; i++) {
				partido.anotarPunto(NumeroDeJugador.UNO);
			}

	        Assert.assertEquals(false, partido.tieneVentaja(NumeroDeJugador.UNO));
	        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
	        Assert.assertEquals(2, partido.obtenerGames(NumeroDeJugador.UNO));
	 }
	
	@Test
	public void unJugadorGana6GamesYGanaUnset() {
		
			for(int i=0; i<24; i++) {
				partido.anotarPunto(NumeroDeJugador.UNO);
			}

			Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.UNO));
			Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
	 }
	
	

	
	
	
	
	
	
	
	
}