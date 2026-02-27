# Tarea1_progra3
# Búsqueda eficiente sobre grandes volúmenes de datos

## Descripción 

Este programa genera números aleatorios, los almacena en un archivo de texto y los carga en dos estructuras de datos distintas: un Árbol Binario de Búsqueda y una Tabla Hash.  

Posteriormente se realizan 1,000 búsquedas automáticas y se mide el tiempo promedio de cada estructura.

---

## Tabla Comparativa de Rendimiento

| Estructura      | Tiempo Promedio (ms) | Complejidad |
|---------------|---------------------|-------------|
| Árbol Binario | 0.00118 ms          | O(log n)   |
| Tabla Hash    | 0.000372 ms         | O(1)       |

---

## Análisis

El árbol binario tiene una complejidad promedio de O(log n), ya que divide el espacio de búsqueda en cada comparación.

La tabla hash tiene complejidad O(1) en promedio, ya que accede directamente al elemento mediante una función hash.

Según los resultados obtenidos, la tabla hash fue más rápida en tiempo de búsqueda.

---

## Conclusión

Para grandes volúmenes de datos, la Tabla Hash es la estructura más eficiente en términos de tiempo de búsqueda.
