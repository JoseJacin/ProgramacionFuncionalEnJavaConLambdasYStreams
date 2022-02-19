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