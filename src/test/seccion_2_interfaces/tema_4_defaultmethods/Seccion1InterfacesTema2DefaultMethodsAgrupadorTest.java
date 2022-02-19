package seccion_2_interfaces.tema_4_defaultmethods;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Seccion1InterfacesTema2DefaultMethodsAgrupadorTest {

	/**
	 * Completad la definicion de la clase AgrupadorConList 
	 * para que implemente la interface
	 * (este ejercicio es de repaso, no usa los metodos default)
	 */
	@Test
	public void test_add() {
		Seccion1InterfacesTema2DefaultMethodsAgrupador agrupador = new Seccion1InterfacesTema2DefaultMethodsAgrupadorConList();
		assertEquals(0, agrupador.numeroElementos());
		
		agrupador.add("primero");
		assertEquals(1, agrupador.numeroElementos());
	}

	/**
	 * definid un metodo default addAll que acepte un Collection y
	 * añada cada objeto al agrupador
	 * Cuando tengais el metodo, descomentad el codigo comentado en el test
	 */
	@Test
	public void test_addAll() {
		Seccion1InterfacesTema2DefaultMethodsAgrupador agrupador = new Seccion1InterfacesTema2DefaultMethodsAgrupadorConList();
		agrupador.addAll(Arrays.asList("primero","segundo"));
		
		assertEquals(2,agrupador.numeroElementos());
	}
}
