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
	public void unJugadorGana6Games() {
		
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
	
	@Test
	public void elJugadorDosGana6GamesYGanaUnset() {
		
			for(int i=0; i<24; i++) {
				partido.anotarPunto(NumeroDeJugador.DOS);
			}
			
			Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.DOS));
			Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
			Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.UNO));
			Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
	 }
	
	@Test
	public void elJugadorDosGanaDosSetsYElUnoGanaUnSet() {
		
			for(int i=0; i<48; i++) {
				partido.anotarPunto(NumeroDeJugador.DOS);
			}
			
			for(int i=0; i<24; i++) {
				partido.anotarPunto(NumeroDeJugador.UNO);
			}
			
			Assert.assertEquals(2, partido.obtenerSets(NumeroDeJugador.DOS));
			Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
			Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.UNO));
			Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
	 }
	/*
	@Test
	public void ambosJugadoresGanan6GamesYVanATieBreakYElJugadorUnoAnotaUnTanto() {
		
			for(int i=0; i<20; i++) {
				partido.anotarPunto(NumeroDeJugador.DOS);
			}
			
			for(int i=0; i<20; i++) {
				partido.anotarPunto(NumeroDeJugador.UNO);
			}
			
			partido.anotarPunto(NumeroDeJugador.UNO);
			partido.anotarPunto(NumeroDeJugador.UNO);
			partido.anotarPunto(NumeroDeJugador.UNO);
			partido.anotarPunto(NumeroDeJugador.UNO);
			partido.anotarPunto(NumeroDeJugador.DOS);
			partido.anotarPunto(NumeroDeJugador.DOS);
			partido.anotarPunto(NumeroDeJugador.DOS);
			partido.anotarPunto(NumeroDeJugador.DOS);
			
			partido.anotarPunto(NumeroDeJugador.UNO);
			
			
			Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.DOS));
			Assert.assertEquals(6, partido.obtenerGames(NumeroDeJugador.DOS));
			Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.UNO));
			Assert.assertEquals(6, partido.obtenerGames(NumeroDeJugador.UNO));
			Assert.assertEquals(1, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
			
	 }
	 
	 */
	
	@Test
	public void ambosJugadoresGanan6GamesYVanATieBreakYElJugadorUnoAnotaDosTantosYelSegundoUno() {
			
			for(int i=0; i<20; i++) {
				partido.anotarPunto(NumeroDeJugador.UNO);
			}
		
		
			for(int i=0; i<20; i++) {
				partido.anotarPunto(NumeroDeJugador.DOS);
			}
			
			
			partido.anotarPunto(NumeroDeJugador.DOS); //15
			partido.anotarPunto(NumeroDeJugador.DOS); //30
			partido.anotarPunto(NumeroDeJugador.DOS); //40
			partido.anotarPunto(NumeroDeJugador.DOS); //0
			partido.anotarPunto(NumeroDeJugador.UNO); //15
			partido.anotarPunto(NumeroDeJugador.UNO); //30	
			partido.anotarPunto(NumeroDeJugador.UNO); //40	
			partido.anotarPunto(NumeroDeJugador.UNO); //0
			
			partido.anotarPunto(NumeroDeJugador.UNO);
			partido.anotarPunto(NumeroDeJugador.UNO);
			partido.anotarPunto(NumeroDeJugador.DOS);
			
			
			Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.DOS));
			Assert.assertEquals(6, partido.obtenerGames(NumeroDeJugador.DOS));
			Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.UNO));
			Assert.assertEquals(6, partido.obtenerGames(NumeroDeJugador.UNO));
			Assert.assertEquals(2, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
			Assert.assertEquals(1, partido.obtenerPuntajeTieBreak(NumeroDeJugador.DOS));
			
	 }
	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}