package seccion_1_introduccion.tema_2_introduccion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Seccion1IntroduccionTema2IntroduccionTest {

    @Test
    void main() {
        List<String> nombres = Arrays.asList("Juan", "Antonia", "Pedro");

        // asigna a comparadorLongitud un comparador que ordene los strings
        // segun la longitud de MAYOR a MENOR (es decir, al contrario que el ejemplo de
        // la presentacion.
        // * solo debes modificar la siguiente linea, el resto de codigo debe quedar igual *
        Comparator<String> comparadorLongitud = ((o1, o2) -> o2.length() - o1.length());

        assertNotNull(comparadorLongitud);

        Collections.sort(nombres,comparadorLongitud);

        assertEquals("Antonia", nombres.get(0), "El primer elemento deberia ser Antonia");
        assertEquals("Pedro", nombres.get(1), "El segundo elemnento deberia ser Pedro");
        assertEquals("Juan", nombres.get(2), "El tercer elemento debeia ser Juan");
    }
}