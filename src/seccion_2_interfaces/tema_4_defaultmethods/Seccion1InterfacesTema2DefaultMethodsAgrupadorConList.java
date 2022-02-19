package seccion_2_interfaces.tema_4_defaultmethods;

import java.util.ArrayList;
import java.util.List;

public class Seccion1InterfacesTema2DefaultMethodsAgrupadorConList implements Seccion1InterfacesTema2DefaultMethodsAgrupador {

	private List<Object> contenido = new ArrayList<>();

	@Override
	public void add(Object elemento) {
		this.contenido.add(elemento);
	}

	@Override
	public int numeroElementos() {
		return contenido.size();
	}
}
