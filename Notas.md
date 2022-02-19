# Programación funcional en Java 8 con Lambda y Streams

## Interfaces

### Default Methods

Cuando hay muchas clases que implementan un misma Interface, todas ellas deben implementar todos los métodos.
Para evitar esto, están los default methods, que permiten implementar un método en el mismo Interface, evitando así que las clases que implementan la Interface no tengan que implementar dicho método. Por lo tanto las clases que implementan la Interface sólo tienen que implementar los métodos abstractos de la Interface.
Estos métodos pueden ser sobreescritos.
Pueden ejecutar métodos que no se encuentran implentados en la Interface.

#### Normas
1. Una interface puede implementar cualquier número de métodos default.
2. Las clases que implementan una interface pueden sobre-escribir los métodos default.
3. Sin una clase implementa dos interfaces y recibe dos métodos default con la misma firma, es obligatorio re-escribir el método

### Static Methods

Sirven para ofrecer funcionalidad que no depende de la instancia en la que se ejecute el método.
Los métodos estáticos no pueden referenciar a nignún método o variable no estático.
Por defecto tienen visibilidad public.

### Anotaciones

#### @FunctionalInterface

Se refiere cuando una interface tiene 1 sólo método abstract (llamadas Functional Interface), pudiendo tener más tipos de métodos.
Una expresión Lambda no es más que la implementación del método abrtracto de una interface @FunctionalInterface

## Lambdas

### Formato de una Lambda

```java
// La expresión Lambda debe corresponderse con la estructura del métoso abstracto que implementa. tanto en los parámetros como en el resultado de la expresión.
Lambda Parameters -> Lambda Body
```

#### Estructura de una expresión Lambda

##### Parmámetros

Los parámetros se separan por ,
Los paréntesis son opcionales si sólo hay un parámetro.
No es necesario especificar el tipo de dato. Ya que el compilador inferirá el tipo a partir del resultado de la expresión.

#### Cuerpo

Hay dos tipos:

1 - Expresión simple

- El resultado será el valor devuelto por el Lambda

    ```java
    (a, b) -> a + b
    ```

2 - Bloque de sentencias

- El bloque debe ir entre llaves

- Necesita incluír el return

    ```java
    (a, b) -> {
        if (a < 0) {
            return 0;
        }

        return a + b;
    }
    ```


Ejemplos
<table>
<tr>
    <th>Método abstract</th>
    <th>lambda expression</th>
  </tr>
<tr>
<td>

```java
int m (int a, int b)
```

</td>
<td>

  ```java
(a, b) -> a
(int a, int b) -> a
  ```

</td>
</tr>

<tr>
<td>

  ```java
int m (int a)
  ```

</td>
<td>

  ```java
(a) -> a
a -> a
a -> { return a; }
  ```

</td>
</tr>

<tr>
<td>

  ```java
int m ()
  ```

</td>
<td>

  ```java
() -> 5
  ```

</td>
</tr>

<tr>
<td>

  ```java
void m (int b)
  ```

</td>
<td>

  ```java
(a) -> {}
  ```

</td>
</tr>
</table>

### Interfaces Funcionales de Java 8 (java.util.function)

Al trabajar con Lambdas, se necesitan diversos interfaces de propósito general, por ello, en Java 8 se han añadido un conjunto de interfaces funcionales de uso muy general para poder realizar todas las lambda expression que necesitemos.
Estas funcionales se han añadido en el package java.util.function y hay más de 40 tipos nuevos.

Como por ejemplo:
> [NOTA]
> A partir de aquí entenderemos lo siguiente:
>**T**: Hace referencia al dominio de la función, es decir, a los valores que acepta.
>**R**: Hace referencia al recorrido, es decir, al tipo de resultado que produce.

#### Function

Un ejemplo muy general es una función que acepta un objeto y devuelve otro. Este tipo de función está representado por una Interface Funcional llamada Function:

```java
Interface Function<T, R>

// El método de la Interface a implementar es apply
R apply (T t);

// Quedando su uso como en el siguiente ejemplo:
// La función nombre es una función que recibe un objeto de tipo Persona y devuelve el nombre de una persona
Function<Persona, String> nombre = per -> per.getNombre();
```

##### Composiciones con Function

Funciones sencillas se pueden combinar para construir funciones más complejas.
Function ofrece dos posibilidades para componer funciones.

- **andThen**: Añadir funcionalidad posterior
  Crea una función añadiendo a una existente otra que debe realizarse en segundo lugar. Como en el siguiente ejemplo:

```java
// Usamos el ejemplo anterior de la función nombre
Function<Persona, String> nombre = per -> per.getNombre();

// En la seguna asignación, sobre el nombre, retorna el mismo en mayúsuclas
// Sobre la función nombre se aplica la función andThen para ejecutar lo que se indique en andThen después de ejecutar lo que tenía nombre.
nombre = nombre.andThen(it -> it.toUpperCase());
```

- **compose**: Añadir funcionalidad anterior
  Crea una función anteponiendo a una existe otra que debe realizarse en primer lugar. Como en el siguiente ejemplo:

```java
// Usamos el ejemplo anterior de la función nombre
Function<Persona, String> nombre = per -> per.getNombre();
// La función propietario es una función que recibe un objeto de tipo Coche y devuelve un objeto de tipo Persona que es el propietario del coche
Function<Coche, Persona> propietario = it -> it.gerPropietario();

// Sobre la función nombre se aplica la función compose para ejecutar lo que se indique en compose antes de ejecutar lo que tenía nombre, es decir, ejecuta la función propietario y el resultado se lo pasa a nombre.
Function<Coche, String> nombrePropietario = nombre.compose(propietario);
```

#### UnaryOperator

Un operador es un tipo especial de función donde el tipo de dominio (T) es igual al tipo de recorrido (R). Para ello existen los tipos UnaryOperator

```java
Interface UnaryOperator<T>
// T y R son del mismo tipo.

f: T -> T
```

Dado que en los genéricos sólo se pueden usar datos no primitivos, hay interfaces específicas para estos tipos de datos primitivos (int, long, double).

- IntUnaryOperator
- LongUnaryOperator
- DoubleUnaryOperator

También hay interfaces para cuando o bien el dominio (T), el recorrido (R) o ambos son primitivos:

<style type="text/css">
</style>
<table>
<tr>
    <th>Método abstract</th>
    <th>UnaryFunction</th>
  </tr>
<tr>
<td>

```java
f(primitivo) -> R
f (int) -> R
f (long) -> R
f (double) -> R
```

</td>
<td>

  ```java
IntFunction<R>
LongFunction<R>
DoubleFunction<R>
  ```

</td>
</tr>

<tr>
<td>

  ```java
f (T) -> primitivo
f (T) -> int
f (T) -> long
f (T) -> double
  ```

</td>
<td>

  ```java
ToIntFunction<T>
ToLongFunction<T>
ToDoubleFunction<T>
  ```

</td>
</tr>

<tr>
<td>

  ```java
f (primitivo) -> primitivo
  ```

</td>
<td>

  ```java
IntToIntFunction
IntToLongFunction
IntToDoubleFunction
LongToIntFunction
LongToLongFunction
LongToDoubleFunction
DoubleToIntFunction
DoubleToLongFunction
DoubleToDoubleFunction
  ```

</td>
</tr>

</table>

#### Consumer

Un Consumer es un tipo especial de función donde tiene un dominio pero no produce un resultado

```java
Interface Consumer<T>
// No tiene R

// La función impresor imprime por consola el valor recibido por parámetro (it), no produciendo ninguna salida
Consumer<String> impresor = (it) -> {System.out.println(it);}
```

#### Supplier

Un Supplier es un tipo especial de función donde no tiene una entrada pero sí produce una salida.

```java
Interface Suppliert<T>
// No tiene T.

Random random = new Randosm();
Supplier<Integer> generador = () -> random.nextInt();
```

#### Predicate

Un Predicate es un tipo especial de función donde su funcionalidad es evaluar un objeto, devolviendo un boolean

```java
Interface Predicate<T>

f(x) -> boolean

// La función  cadenaCorta retorna true o false en función si el parámetro recibido (it) tiene una longitud menos a 10
Predicate<String> cadenaCorta = it -> it.lenght() < 10;

// Hay predicados para los tipos primitivos
IntPredicate
LongPredicate
DoublePredicate
```

#### Binary*

EL prefijo Binary o Bi se aplica cuando se duplica el número de parámetros de las interfaces lo que produce multitud de interfaces funcionales nuevas.

Por ejemplo:
```java
// BinaryOperator se aplica sobre dos parámetros y produce un resultado del mismo tipo que los parámetros
BinaryOperator<T>    -    f (t, t) -> t

//BiFuncion se aplica sobre dos parámetros (t, u) y produce un resultado (r) 
BiFunction<T, U, R>    -    f (t, u) -> r

//BiPredicate se aplica sobre dos parámetros (t, u)  y produce un resultado boolean.
BiPredicate<T, U>    -    f (t, u) -> boolean

// También se puede aplicar sobre las funciones de tipos primitivos donde recibe dos parámetros del tipo indicado y produce un resultado del mismo tipo
IntBinaryOperator    -    f (int, int) -> int
LongBinaryOperator    -    f (long, long) -> long
DoubleBinaryOperator    -    f (double, double) -> double
```

### Functional Interfaces

En vez de lambda expressions se pueden utilizar métodos ya existentes.

```java
// Por ejemplo:
List<String> lista = Arrays.asList("ab", "b", "ccc");

// Para ordenar un array de Strings según la longitud de los elementos, se puede realizar lo siguiente mediante lambdas expression
lista.sort((01, 02) -> 01.lenght() - o2.lenght());

// Pero puede darse el caso que ya exista un método que realice dicha comparación en otra clase.
// Por ejemplo, en una clase Utilidades ya existe un método estático que tiene la misma firma que necesitamos.
class Utilidades {
    public static int compare (String o1, String o2) {
        return o1.lenght() - o2.lenght();
    }
}

// La forma para rehusarlo sería la siguiente
lista.sort((o1, o2) -> Utilidades.compare(o1, o2));
// El problema de lo anterior es que se ha tenido que reescribir la firma del método en la parte declarativa de la lambda expression

// Para ello, la implementación sería de la siguiente forma:
lista.sort(Utilidades::compare);
// A lo anterior se llama Method Reference
```
