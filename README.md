# Ejercicio 6 - Dashboard modular

Ejercicio individual de Programación Orientada a Objetos.
Joseline Mazariegos.

Es un programa sencillo de consola en Java. Tiene 10 widgets de clima, relojes,
tareas y alertas. Permite listarlos, buscarlos por ID o nombre completo, ordenarlos
por memoria, hacer clic y actualizar los que son interactivos.

## Ejecutar

Necesita JDK 8 o superior. Desde la carpeta del ejercicio:

```sh
mkdir -p out
javac -encoding UTF-8 -d out *.java
java -cp out Principal
```

Para buscar por nombre se ignoran las mayúsculas. Ejemplos: `Clima Guatemala`,
`Tareas de estudio`, `Reunion`. Los ID iniciales van del 1 al 10.
El clima usa datos de ejemplo y los relojes muestran la hora local del equipo.
La actualización es manual con la opción 6, sin conexión a servicios externos.
Las tareas se representan con un contador: el clic completa una y actualizar agrega una.
La alerta se marca como leída con un clic y actualizar la activa otra vez.
Todos los widgets cargados se consideran activos. No se guardan cambios al salir.

## Diseño

El PDF `analisis-diseno.pdf` contiene el análisis y el diagrama UML.
`diseno.txt` contiene el esquema usado antes de implementar.

- Modelo: Dashboard, Widget, Clima, Reloj, Tareas, Alerta y las interfaces.
- Vista: Principal, que contiene toda la entrada y salida de consola.
- Controlador: Controlador, que conecta las opciones con el modelo.

Solo hay una lista de widgets, en Dashboard. Widget implementa Renderizable y
Comparable<Widget>. Tareas y Alerta también implementan Interactivo.
Para agregar otro tipo se crea una subclase de Widget y se agrega al catálogo.
No hace falta modificar el recorrido de Dashboard ni Controlador.

## Comprobaciones

```sh
javac -encoding UTF-8 -d out *.java
java -cp out PruebaDashboard
```

Si no hay errores, terminan sin mensajes. Comprueban búsquedas, ordenamiento,
interacción, actualización, tareas vacías, ID duplicado y un nuevo tipo de widget.
