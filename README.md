<h2 align="center"> RECORRIDOS EN PROFUNDIDAD </h2> 

## PLANTEAMIENTO

Diseñe en UML e implemente las clases necesarias para efectuar los
`recorridos en profundidad` _(preorden, inorden y postorden)_ de los nodos de un
_árbol_ (por ejemplo de un `JTree`).

Se deben usar `expresiones
lambdas`, que instancien a `interfaces funcionales` para
cada tipo de recorrido desde su punto de inicio _(la raíz del árbol)_.

Considere que el contenido (texto o valor) de los nodos del JTree son valores numéricos,
aun cuando se indiquen como texto (String). En todo caso, el resultado de
cada recorrido se debe añadir como una línea nueva en un JTextArea, De modo que:

* En el recorrido _PreOrden_ solo se muestren los valores de nodos que tienen un valor numérico _par_.
* En el recorrido _InoOden_ solo se muestren los valores de nodos que tienen un valor numérico _impar_.
* En el recorrido _PostOrden_ solo se muestren los valores de nodos que tienen valores numéricos _impares múltiplos de tres_.

## VISTA DEL PROYECTO

