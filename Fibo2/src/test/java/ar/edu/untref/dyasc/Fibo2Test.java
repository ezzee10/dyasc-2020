package ar.edu.untref.dyasc;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Fibo2Test
{
	@Test //HORIZONTAL Y DIRECTO
	public void test1() {

		Fibo2 f = new Fibo2();
		int[] serie = f.generarSerieFibonacci(6); //cantidad
		String valorEsperado = "fibo<6>: 0 1 1 2 3 5";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie, true, true));
		
	}
	
	@Test //HORIZONTAL E INVERSO
	public void test2() {
		Fibo2 f = new Fibo2();
		int[] serie = f.generarSerieFibonacci(10); //cantidad
		String valorEsperado = "fibo<10>: 34 21 13 8 5 3 2 1 1 0";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie, true, false));
	}
	
	@Test //VERTICAL Y DIRECTO
	public void test3() {
		
		Fibo2 f = new Fibo2();
		int[] serie = f.generarSerieFibonacci(5); //cantidad
		String valorEsperado = "fibo<5>:\n0\n1\n1\n2\n3";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie, false, true));
	}

	@Test //VERTICAL E INVERSO
	public void test4() {

		Fibo2 f = new Fibo2();
		int[] serie = f.generarSerieFibonacci(5); //cantidad
		String valorEsperado = "fibo<5>:\n3\n2\n1\n1\n0";
		Assert.assertEquals(valorEsperado, f.orientacionYdireccion(serie,false, false));
		
	}
}

