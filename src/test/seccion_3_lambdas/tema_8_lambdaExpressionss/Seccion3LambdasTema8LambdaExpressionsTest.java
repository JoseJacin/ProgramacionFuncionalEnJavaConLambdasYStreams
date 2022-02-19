package seccion_3_lambdas.tema_8_lambdaExpressionss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Seccion3LambdasTema8LambdaExpressionsTest {
    private Seccion3LambdasTema8LambdaExpressions fact = new Seccion3LambdasTema8LambdaExpressions();

    @Test
    public void test_sumador () {
        assertEquals(5, fact.obtenSumador().opera(2, 3));
    }

    @Test
    public void test_devuelve5 () {
        assertEquals(5, fact.devuelve5().valor());
    }

    @Test
    public void test_inicializador() {
        String[] array = new String[4];

        fact.obtenInicializador().inicializa(array, "A");

        assertArrayEquals(array, new String[] {"A","A","A","A"});
    }
}