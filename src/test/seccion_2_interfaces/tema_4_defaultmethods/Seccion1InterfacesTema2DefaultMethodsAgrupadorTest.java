package test.seccion_2_interfaces.tema_4_defaultmethods;

import org.junit.jupiter.api.Test;
import seccion_2_interfaces.tema_4_defaultmethods.Seccion1InterfacesTema2DefaultMethodsAgrupador;
import seccion_2_interfaces.tema_4_defaultmethods.Seccion1InterfacesTema2DefaultMethodsAgrupadorConList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
	 * a�ada cada objeto al agrupador
	 * Cuando tengais el metodo, descomentad el codigo comentado en el test
	 */
	@Test
	public void test_addAll() {
		Seccion1InterfacesTema2DefaultMethodsAgrupador agrupador = new Seccion1InterfacesTema2DefaultMethodsAgrupadorConList();
		// agrupador.addAll(Arrays.asList("primero","segundo"));
		
		assertEquals(2,agrupador.numeroElementos());
	}
}
