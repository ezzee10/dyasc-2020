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
	
	@Test
	public void ambosJugadoresGanan6GamesYVanATieBreakYElJugadorUnoLlegaA7TantosYGanaElSet() {
		
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
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		//partido.anotarPunto(NumeroDeJugador.DOS);
		
		Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.DOS));
		Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.UNO));
		//Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.DOS));
		
	}
	
	@Test
	public void ambosJugadoresGanan6GamesYVanATieBreakYElJugadorUnoLlegaA7TantosYGanaElSetYluegoElJugador2MeteUnNuevoPunto() {
		
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
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.UNO);
		partido.anotarPunto(NumeroDeJugador.DOS);
		
		Assert.assertEquals(15, partido.obtenerPuntaje(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.DOS));
		Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.DOS));
		
	}
	
	@Test
	public void unJugadorGanaUnSetLuegoVanATieBreakYTerminan7a5() {
		
		for(int i=0; i<24; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO); //GANA UN SET
		}
		
		for(int i=0; i<20; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO);  //5 GAMES 
		}
	
	
		for(int i=0; i<20; i++) {
			partido.anotarPunto(NumeroDeJugador.DOS); //5 GAMES
		}
		

		partido.anotarPunto(NumeroDeJugador.DOS); //15
		partido.anotarPunto(NumeroDeJugador.DOS); //30
		partido.anotarPunto(NumeroDeJugador.DOS); //40
		partido.anotarPunto(NumeroDeJugador.DOS); //0          
		partido.anotarPunto(NumeroDeJugador.UNO); //15
		partido.anotarPunto(NumeroDeJugador.UNO); //30	
		partido.anotarPunto(NumeroDeJugador.UNO); //40	
		partido.anotarPunto(NumeroDeJugador.UNO); //0           6 a 6
		
		
		partido.anotarPunto(NumeroDeJugador.DOS); //1
		partido.anotarPunto(NumeroDeJugador.DOS); //2
		partido.anotarPunto(NumeroDeJugador.UNO); //1
		partido.anotarPunto(NumeroDeJugador.UNO); //2	
		partido.anotarPunto(NumeroDeJugador.UNO); //3	
		partido.anotarPunto(NumeroDeJugador.DOS); //3
		partido.anotarPunto(NumeroDeJugador.DOS); //4
		partido.anotarPunto(NumeroDeJugador.UNO); //4
		partido.anotarPunto(NumeroDeJugador.UNO); //5
		partido.anotarPunto(NumeroDeJugador.DOS); //5
		partido.anotarPunto(NumeroDeJugador.DOS); //6
		partido.anotarPunto(NumeroDeJugador.DOS); //7          7 a 5 POR LO TANTO GANA EL GAME Y VAN 1 A 1 EN SETS
		
		partido.anotarPunto(NumeroDeJugador.UNO); //15
		partido.anotarPunto(NumeroDeJugador.DOS); //15         EN EL TERCER SET VAN 15 A 15 
		
		
		Assert.assertEquals(15, partido.obtenerPuntaje(NumeroDeJugador.DOS));
		Assert.assertEquals(15, partido.obtenerPuntaje(NumeroDeJugador.UNO));
		Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.DOS));
		Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.DOS));
	}
	
	@Test
	public void enTieBreakambosLlevan6PuntosYUnJugadorAnotaUnPuntoYNoGanaDebidoADiferenciaDe2() {
		
		for(int i=0; i<20; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO);  //5 GAMES 
		}
	
	
		for(int i=0; i<20; i++) {
			partido.anotarPunto(NumeroDeJugador.DOS); //5 GAMES
		}
		
		partido.anotarPunto(NumeroDeJugador.DOS); //15
		partido.anotarPunto(NumeroDeJugador.DOS); //30
		partido.anotarPunto(NumeroDeJugador.DOS); //40
		partido.anotarPunto(NumeroDeJugador.DOS); //0          
		partido.anotarPunto(NumeroDeJugador.UNO); //15
		partido.anotarPunto(NumeroDeJugador.UNO); //30	
		partido.anotarPunto(NumeroDeJugador.UNO); //40	
		partido.anotarPunto(NumeroDeJugador.UNO); //0           6 a 6
		
		partido.anotarPunto(NumeroDeJugador.DOS); //1
		partido.anotarPunto(NumeroDeJugador.DOS); //2
		partido.anotarPunto(NumeroDeJugador.UNO); //1
		partido.anotarPunto(NumeroDeJugador.UNO); //2	
		partido.anotarPunto(NumeroDeJugador.UNO); //3	
		partido.anotarPunto(NumeroDeJugador.DOS); //3
		partido.anotarPunto(NumeroDeJugador.DOS); //4
		partido.anotarPunto(NumeroDeJugador.UNO); //4
		partido.anotarPunto(NumeroDeJugador.UNO); //5
		partido.anotarPunto(NumeroDeJugador.DOS); //5
		partido.anotarPunto(NumeroDeJugador.DOS); //6
		partido.anotarPunto(NumeroDeJugador.UNO); //6 
		partido.anotarPunto(NumeroDeJugador.UNO); //7
		
		Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.UNO));
		Assert.assertEquals(6, partido.obtenerGames(NumeroDeJugador.DOS));
		Assert.assertEquals(6, partido.obtenerGames(NumeroDeJugador.UNO));
		Assert.assertEquals(7, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
		Assert.assertEquals(6, partido.obtenerPuntajeTieBreak(NumeroDeJugador.DOS));
			
	}
	
	@Test
	public void jugadorGanaSet8A6EnTieBreakLuegoJugador1MarcaDosPuntosEnSetNuevo() {
		
		for(int i=0; i<20; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO);  //5 GAMES 
		}
	
	
		for(int i=0; i<20; i++) {
			partido.anotarPunto(NumeroDeJugador.DOS); //5 GAMES
		}
		
		partido.anotarPunto(NumeroDeJugador.DOS); //15
		partido.anotarPunto(NumeroDeJugador.DOS); //30
		partido.anotarPunto(NumeroDeJugador.DOS); //40
		partido.anotarPunto(NumeroDeJugador.DOS); //0          
		partido.anotarPunto(NumeroDeJugador.UNO); //15
		partido.anotarPunto(NumeroDeJugador.UNO); //30	
		partido.anotarPunto(NumeroDeJugador.UNO); //40	
		partido.anotarPunto(NumeroDeJugador.UNO); //0           6 a 6
		
		partido.anotarPunto(NumeroDeJugador.DOS); //1
		partido.anotarPunto(NumeroDeJugador.DOS); //2
		partido.anotarPunto(NumeroDeJugador.UNO); //1
		partido.anotarPunto(NumeroDeJugador.UNO); //2	
		partido.anotarPunto(NumeroDeJugador.UNO); //3	
		partido.anotarPunto(NumeroDeJugador.DOS); //3
		partido.anotarPunto(NumeroDeJugador.DOS); //4
		partido.anotarPunto(NumeroDeJugador.UNO); //4
		partido.anotarPunto(NumeroDeJugador.UNO); //5
		partido.anotarPunto(NumeroDeJugador.DOS); //5
		partido.anotarPunto(NumeroDeJugador.DOS); //6
		partido.anotarPunto(NumeroDeJugador.UNO); //6 
		partido.anotarPunto(NumeroDeJugador.DOS); //7
		partido.anotarPunto(NumeroDeJugador.DOS); //8
		
		partido.anotarPunto(NumeroDeJugador.UNO); //15 puntos
		partido.anotarPunto(NumeroDeJugador.UNO); //30 puntos
		
		Assert.assertEquals(30, partido.obtenerPuntaje(NumeroDeJugador.UNO));
		Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
		Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.UNO));
		Assert.assertEquals(0, partido.obtenerPuntajeTieBreak(NumeroDeJugador.DOS));
			
	}
	
	@Test
	public void jugadorGana3SetsSeguidosYGanaElPartido() {
		
		for(int i=0; i<24; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO);  //1SET
		}
	
	
		for(int i=0; i<24; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO); //2 SETS
		}
		
		for(int i=0; i<24; i++) {
			partido.anotarPunto(NumeroDeJugador.UNO); //3 SETS
		}
		
		
		Assert.assertEquals(0, partido.obtenerSets(NumeroDeJugador.DOS));
		Assert.assertEquals(3, partido.obtenerSets(NumeroDeJugador.UNO));
		Assert.assertEquals(NumeroDeJugador.UNO, partido.obtenerGanador(NumeroDeJugador.UNO));

			
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}