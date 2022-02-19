package seccion_2_interfaces.tema_4_defaultmethods;

import java.util.Collection;

public interface Seccion1InterfacesTema2DefaultMethodsAgrupador {

	void add (Object elemento);
	
	int numeroElementos();

	default void addAll(Collection<Object> collection) {
		collection.forEach(this::add);
	}
}
