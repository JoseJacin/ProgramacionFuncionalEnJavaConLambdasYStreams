package seccion_4_functionalInterfaces.tema_10_javaUtilFunction;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

class Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersonaTest {
    /**
     * Modificad el test asignando a la variable cuadrado una expresion que produzca un
     * IntUnaryOperator que, dado un entero, devuelva su cuadrado.
     */

    @Test
    public void test_function() {
        IntUnaryOperator cuadrado = a -> a * a;

        assertEquals(0, cuadrado.applyAsInt(0));
        assertEquals(1, cuadrado.applyAsInt(1));
        assertEquals(4, cuadrado.applyAsInt(2));
        assertEquals(9, cuadrado.applyAsInt(3));
    }

    /**
     * Igual que el anterior, sustituid el null asignado a menor por una expresion que
     * produzca un operador que devuelva el menor de dos numeros
     */
    @Test
    public void test_funcion_2() {
        //LongBinaryOperator menor = (a, b) -> a < b ? a : b;
        LongBinaryOperator menor = Math::min;

        assertEquals(-2, menor.applyAsLong(-2, 3));
        assertEquals(5, menor.applyAsLong(10, 5));
    }

    /**
     * En los siguientes ejercicios debereis implementar tanto la declaracion de la
     * interface funcional como la lambda expression a assignar.
     * Se utiliza el termino generico funcion, pero la opcion a usar puede ser cualquier tipo de
     * interface funcional del JDK
     * Este ejercicio no tiene pruebas unitarias, ya que parte del ejercicio es determinar que tipo
     * es el mas adecuado en cada caso y, sin la variable declarada con su tipo, es dificil hacer un test!
     * Por este motivo, debereis probar vosotros mismos vuestros resultados. Para facilitaros las pruebas
     * se crean tres personas con distintos apellidos.
     */
    @Test
    public void test_extras() {
        // personas creadas para las pruebas
        Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona personaSinSegundoApellido = new Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona ("nombre","apellido1",null);
        Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona personaConSegundoApellido = new Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona ("nombre", "apellido1", "apellido2");
        Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona personaNoPariente = new Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona ("nombre","otro","otro");

        // Cread una funcion que indique si el segundo apellido de una persona es null
        Predicate<Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona> segundoApellidoNull = p -> StringUtils.isBlank(p.getApellido2());
        assertTrue(segundoApellidoNull.test(personaSinSegundoApellido));
        assertFalse(segundoApellidoNull.test(personaConSegundoApellido));

        // Una funcion que nos diga si dos personas son parientes: para nosotros parientes
        // son personas con el mismo primer apellido
        BiPredicate<Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona, Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona> sonParientes = (p1, p2) -> p1.getApellido1().equals(p2.getApellido1());
        assertTrue(sonParientes.test(personaSinSegundoApellido, personaConSegundoApellido));
        assertFalse(sonParientes.test(personaSinSegundoApellido, personaNoPariente));

        // Una funcion que "enmascare" los datos de una persona: debe permutar los valores de sus
        // y nombre
        Consumer<Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona> enmascarar = p -> {
            String aux = p.getApellido1();
            p.setApellido1(p.getApellido2());
            p.setApellido2(p.getNombre());
            p.setNombre(aux);
        };

        enmascarar.accept(personaConSegundoApellido);

        assertEquals("apellido1", personaConSegundoApellido.getNombre());
        assertEquals("apellido2", personaConSegundoApellido.getApellido1());
        assertEquals("nombre", personaConSegundoApellido.getApellido2());
    }

    @Test
    public void test_validadores() {
        /**
         * Modificad la clase validador conforme las instrucciones que encontrareis ahi
         *
         * Hecho esto, descomentad el codigo que sigue (que, con vuestros cambios en Validador deberia
         * compilar excepto por el contenido en la invocacion al metodo add.
         * Como parametro al metodo add debereis pasar una expresion que produzca el tipo de funcion que
         * hayais decidido que usa la clase Validador
         */
        Seccion4FunctionalInterfacesTema10JavaUtilFunctionValidador<Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona> validador
                = new Seccion4FunctionalInterfacesTema10JavaUtilFunctionValidador<>();

        validador.add(p -> !StringUtils.isBlank(p.getApellido1()));

        assertTrue(validador.valida(new Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona("nombre","ape1","ape2")));
        assertFalse(validador.valida(new Seccion4FunctionalInterfacesTema10JavaUtilFunctionPersona("nombre",null,"ape2")));
    }
}