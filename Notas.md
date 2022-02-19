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
