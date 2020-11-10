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
	
}