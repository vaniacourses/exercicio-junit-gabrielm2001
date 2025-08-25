package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testMultiplicacaoDoisNumeros(){
		int multiplicacao = calc.multiplicacao(4, 3);
		Assertions.assertEquals(12, multiplicacao);
	}

	@Test
	public void testComparacaoDoisNumeros(){
		int compararIguais = calc.compara(0, 0);
		int compararDiferentes = calc.compara(1, 0);

		Assertions.assertEquals(0, compararIguais);
		Assertions.assertEquals(1, compararDiferentes);
	} 

	@Test
	public void testPositivoNumeros(){
		boolean negativo = calc.ehPositivo(-1);
		boolean positivo = calc.ehPositivo(0);

		Assertions.assertEquals(true, positivo);
		Assertions.assertEquals(false, negativo);
	}

	@Test
	public void testSomatorio(){
		int somatorio = calc.somatoria(3);

		Assertions.assertEquals(6, somatorio);
	}

	@Test
	public void testSubtracao(){
		int subtracao = calc.subtracao(1, 1);

		Assertions.assertEquals(0, subtracao);
	}

}
