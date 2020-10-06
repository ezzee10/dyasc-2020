package ar.edu.untref.dyasc;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Fibo3Test
{
	@Test //HORIZONTAL Y DIRECTO
	public void test1() {

		Fibo3 f = new Fibo3();
		int[] serie = f.generarSerieFibonacci(6); //cantidad
		String valorEsperado = "fibo<6>: 0 1 1 2 3 5";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie, true, true, false));
		
	}
	
	@Test //HORIZONTAL E INVERSO
	public void test2() {
		Fibo3 f = new Fibo3();
		int[] serie = f.generarSerieFibonacci(10); //cantidad
		String valorEsperado = "fibo<10>: 34 21 13 8 5 3 2 1 1 0";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie, true, false, false));
	}
	
	@Test //VERTICAL Y DIRECTO
	public void test3() {
		
		Fibo3 f = new Fibo3();
		int[] serie = f.generarSerieFibonacci(5); //cantidad
		String valorEsperado = "fibo<5>:\n0\n1\n1\n2\n3";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie, false, true, false));
	}

	@Test //VERTICAL E INVERSO
	public void test4() {

		Fibo3 f = new Fibo3();
		int[] serie = f.generarSerieFibonacci(5); //cantidad
		String valorEsperado = "fibo<5>:\n3\n2\n1\n1\n0";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie,false, false, false));
		
	}
	
	@Test //SUMATORIA
	public void test5() {

		Fibo3 f = new Fibo3();
		int[] serie = f.generarSerieFibonacci(5); //cantidad
		int valorEsperado = 7;
		Assert.assertEquals(valorEsperado, f.realizarSumatoriaDeSerie(serie));
		
	}
}

