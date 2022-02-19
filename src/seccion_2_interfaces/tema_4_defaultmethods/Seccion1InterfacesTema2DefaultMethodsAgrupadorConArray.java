package seccion_2_interfaces.tema_4_defaultmethods;

import java.util.ArrayList;
import java.util.List;

public class Seccion1InterfacesTema2DefaultMethodsAgrupadorConArray implements Seccion1InterfacesTema2DefaultMethodsAgrupador {

	private Object[] contenido = new Object[20];
	private int index = 0;
	
	@Override
	public void add(Object elemento) {
		contenido[index++] = elemento;
	}

	@Override
	public int numeroElementos() {
		return index;
	}
}
