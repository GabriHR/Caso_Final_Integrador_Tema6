# Caso Final Integrador Tema 6: Sistema de Gestión y Análisis de Datos Multidimensionales

Caso Final Integrador del Tema 6 desarrollado por Gabriel Hernanz Rodríguez.

LINK: https://github.com/GabriHR/Caso_Final_Integrador_Tema6.git


## Índice
1. [DESCRIPCIÓN](#descripción)
2. [MÓDULOS](#módulos)
   - [1. Gestión de Datos Dinámicos](#gestión-de-datos-dinámicos)
   - [2. Análisis y Organización de Información](#análisis-y-organización-de-información)
   - [3. Mapas y Asociación de Datos](#mapas-y-asociación-de-datos)
   - [4. Indexación y Visualización de Archivos](#indexación-y-visualización-de-archivos)
3. [CRITERIOS EVALUACIÓN](#criterios-evaluación)
4. [RÚBRICA](#rÚbrica)

## DESCRIPCIÓN

El proyecto consistirá en el desarrollo de una aplicación de software que integre varias estructuras de datos, algoritmos de ordenación y búsqueda, y métodos interactivos de entrada y salida de datos. Los estudiantes aplicarán conceptos avanzados de programación y estructuras de datos para crear una herramienta versátil y eficiente.

## MÓDULOS

### 1. Gestión de Datos Dinámicos [Gestion_Datos_Dinamicos]
Consiste en una interfaz gráfica que le permita al usuario escoger con que tipo de dato trabajar, listas de números o matrices, listas de datos reales o pares de números enteros.

Clases:
   - La clase Pareja es una clase simple en Java que representa un par de números enteros. Cada objeto Pareja tiene dos variables de instancia, primero y segundo, que se establecen a través del constructor de la clase. La clase proporciona métodos getter para recuperar estos valores
   - La clase ListaDatos es una clase en Java que representa una lista de datos reales y una lista de objetos Pareja. Esta clase extiende Observable, lo que significa que puede tener observadores que son notificados cuando cambia el estado de ListaDatos. Proporciona métodos para agregar elementos a estas listas y recuperar estas listas. Además, notifica a los observadores cuando se agregan elementos a las listas.
   - La clase Gestion_Datos_Window es una clase en Java que representa una ventana de interfaz gráfica de usuario (GUI) que permite al usuario interactuar con una lista de datos reales y una lista de objetos Pareja. Configura la interfaz gráfica de usuario y establece los oyentes de eventos para los botones y campos de texto. Cuando se presiona el botón "Agregar datos", se recogen los datos de los campos de texto, se agregan a la lista de datos y se actualiza el área de texto.

### 2. Análisis y Organización de Información [Analisis_Organizacion_Informacion]

En el módulo correspondiente al packager Analisis_Organizacion_Informacion, existe el código necesario para gestionar las ventas y transacciones bancarias. En el se controlan/manejan la fecha de dicha transacción, el cliente que la realiza y su nombre, el tipo de producto que es comprado y la cantidad que se compra él.

Clases: 
   - Clase Venta: Esta clase representa una venta realizada. Cada objeto Venta tiene cuatro atributos: cliente, producto, cantidad y fecha. La clase proporciona métodos getter para recuperar estos valores.
   - Clase Ordenacion_Busqueda: Esta clase representa una lista de objetos Venta y proporciona métodos para agregar ventas a la lista y recuperar la lista de ventas. Cuando se agrega una venta a la lista, la lista se ordena por la fecha de las ventas.
   - Clase Analisis_Registros: Esta clase representa una lista de objetos Venta y proporciona métodos para agregar ventas a la lista y filtrar la lista de ventas por varios criterios, incluyendo el cliente, el producto, el mes, el año y la fecha de la venta.
   - Clase Analisis_Window: Esta clase representa una ventana de interfaz gráfica de usuario (GUI) que permite al usuario interactuar con una lista de ventas y realizar operaciones de análisis en ellas. La ventana muestra los datos de las ventas en una tabla y proporciona botones para ordenar y filtrar los datos.

### 3. Mapas y Asociación de Datos [Mapas_Asociacion_Datos]

Esta parte del código es la encargada de ayudar al usuario a gestionar y recuperar datos y credenciales de manera rápida y eficiente.

Clases:
   - Clase Gestion_Relaciones: Esta clase en Java representa un mapa de relaciones entre números enteros y cadenas de texto. Proporciona métodos para agregar una relación al mapa (agregarRelacion), eliminar una relación del mapa (eliminarRelacion) y obtener el texto asociado a un número (obtenerTexto).
   - Clase Gestion_Relaciones_Window: Esta clase en Java representa una ventana de interfaz gráfica de usuario (GUI) que permite al usuario interactuar con las relaciones almacenadas en las instancias de Gestion_Relaciones y Recuperacion_Eficiente. Proporciona un método para mostrar las relaciones (mostrarRelaciones) y un botón para volver al menú principal.
   - Clase Recuperacion_Eficiente: Esta clase en Java representa un mapa de asociaciones entre números enteros y caracteres. Proporciona métodos para agregar una asociación al mapa (agregarAsociacion), eliminar una asociación del mapa (eliminarAsociacion) y obtener el carácter asociado a un número (obtenerLetra).

### 4. Indexación y Visualización de Archivos [Indexacion_Visualizacion_Archivos]

Esta formado por un conjunto de clases que proporcionan al usuario, la opción/funcionalidad de indexar y listar archivos en un directorio dado. Los archivos se pueden buscar por su nombre o directamente navegando en el Explorador de Archivos de la computadora. Además, todos los archivos seleccionados se añadirán a una lista (cada uno con su ruta correspondiente) y podrán ser ordenados alfabéticamente.

Clases:

   - Clase Nodo: Esta clase en Java representa un nodo en un árbol de búsqueda de trie. Cada nodo puede tener varios hijos, donde cada hijo se identifica por un carácter. Un nodo puede representar el final de una ruta en el árbol de búsqueda de trie.  
   - Clase Indexacion_Recursiva: Esta clase en Java representa un índice de rutas de archivos en un sistema de archivos. Proporciona métodos para insertar rutas en el índice, buscar rutas en el índice y obtener una lista de todas las rutas indexadas.  
   - Clase Indexacion_Recursiva_Window: Esta clase en Java representa una ventana de interfaz gráfica de usuario (GUI) que permite al usuario interactuar con la indexación recursiva de archivos. Proporciona un botón para iniciar la indexación recursiva de un directorio y un área de texto para ver las rutas indexadas.  
   - Clase Ordenacion_Listado: Esta clase en Java representa una interfaz gráfica de usuario (GUI) que permite al usuario seleccionar archivos y ver sus nombres y rutas en orden alfabético. Proporciona un botón para seleccionar más archivos y otro botón para volver al menú principal.

### Main.java

Esta clase es utilizada para crear una interfaz gráfica que le permita al usuario interactuar las diferentes funcionalidades de gestión y análisis de datos.
   - Inicializa varias instancias de clases como ListaDatos, Ordenacion_Busqueda, Analisis_Registros, Gestion_Relaciones, Recuperacion_Eficiente y un área de texto.  
   - Configura una serie de botones que permiten al usuario interactuar con las funcionalidades de la aplicación, como agregar datos, realizar análisis de registros, gestionar relaciones, realizar recuperación eficiente de datos, iniciar indexación recursiva y ordenar y listar archivos.  
   - Implementa la interfaz Observer para actualizar el área de texto cuando los datos observados cambian.  
   - Maneja el redimensionamiento de una imagen cuando la ventana es redimensionada.  
   - Muestra un título y un texto de derechos de autor en la ventana.  
   - El método main inicia la aplicación creando una nueva instancia de la clase Main.

# ENTREGABLES

   - Software de Gestión y Análisis de Datos: Un programa interactivo que integre todas las funcionalidades mencionadas, con una interfaz de usuario que facilite su uso por parte de analistas, investigadores o cualquier persona interesada en la manipulación de datos complejos.

   - Documento de Diseño y Especificaciones: Un informe detallado que incluya la descripción de cada módulo, ejemplos de uso, y explicaciones de cómo se manejan los datos y las estructuras en la aplicación.

# EVALUACIÓN 

Este proyecto final integrador desafía a los estudiantes a aplicar sus conocimientos en un contexto real y significativo, promoviendo la innovación y la aplicación práctica de estructuras de datos y algoritmos para resolver problemas complejos de gestión y análisis de datos.

   - Funcionalidad y Correctitud: ¿El sistema realiza todas las tareas requeridas de manera efectiva y produce resultados precisos?

   - Eficiencia del Código: ¿Es el código bien estructurado, eficiente y fácil de entender?

   - Aplicación de Estructuras de Datos: ¿Se utilizan las estructuras de datos apropiadas para cada funcionalidad de manera efectiva?

   - Interfaz de Usuario: ¿La interfaz es intuitiva y facilita la manipulación y visualización de los datos?

   - Documentación y Presentación: ¿Está bien documentado y presentado el diseño, la implementación y el uso de cada herramienta?

# CRITERIOS DE EVALUACIÓN + RÚBRICA
### Funcionalidad y Correctitud (25%)

   - Excelente (100%): Todas las funcionalidades implementadas funcionan correctamente sin errores, y manejan casos extremos eficientemente. Cumple con todos los requisitos y especificaciones.

   - Bueno (75%): La mayoría de las funcionalidades funcionan correctamente, con errores menores que no afectan la funcionalidad general.

   - Adecuado (50%): Las funcionalidades básicas están presentes y funcionan, pero hay errores notables o problemas en casos extremos.

   - Insuficiente (25%): Varios componentes no funcionan correctamente, afectando significativamente la usabilidad y efectividad del sistema.

### Eficiencia del Código (20%)

   - Excelente (100%): Código bien estructurado, eficiente y optimizado, fácil de entender y mantener.

   - Bueno (75%): Código generalmente bien organizado y funcional con pequeñas áreas que podrían ser optimizadas.

   - Adecuado (50%): Código funcional pero con espacio evidente para mejorar en términos de estructura, eficiencia y claridad.

   - Insuficiente (25%): Código desordenado, ineficiente y difícil de entender o mantener.

### Aplicación de Estructuras de Datos (20%)

   - Excelente (100%): Uso impecable de estructuras de datos adecuadas y complejas para mejorar la funcionalidad y eficiencia del sistema.

   - Bueno (75%): Buen uso de estructuras de datos con pequeñas áreas para mejora. Mayoría de los principios aplicados correctamente.

   - Adecuado (50%): Uso básico de estructuras de datos pero con algunos conceptos aplicados incorrectamente o no utilizados donde serían beneficiosos.

   - Insuficiente (25%): Poca o incorrecta aplicación de estructuras de datos, o elección inapropiada de las mismas para las tareas requeridas.

### Interfaz de Usuario (20%)

   - Excelente (100%): La interfaz es intuitiva, estéticamente agradable, y facilita una navegación fluida y una experiencia de usuario positiva.

   - Bueno (75%): La interfaz es funcional y generalmente fácil de usar, pero con algunas áreas que podrían mejorarse para una mejor experiencia.

   - Adecuado (50%): La interfaz cumple con los requisitos básicos, pero carece de refinamiento y claridad en algunos aspectos.

   - Insuficiente (25%): La interfaz es confusa, difícil de navegar, o visualmente poco atractiva.

### Documentación y Presentación (15%)

   - Excelente (100%): Documentación y presentación excepcionales, incluyendo detalles completos, claros y bien organizados del sistema, con ejemplos y casos de prueba.

   - Bueno (75%): Documentación y presentación bien realizadas con algunas áreas menores que podrían mejorarse.

   - Adecuado (50%): Documentación y presentación básicas que cubren los requisitos pero carecen de detalles y claridad.

   - Insuficiente (25%): Documentación y presentación pobres, faltan detalles importantes, y es difícil entender el sistema y su funcionamiento.

**Total de Puntos Posibles: 100**

### Escala de Calificación:

   - 90-100: Sobresaliente

   - 80-89: Muy Bueno

   - 70-79: Bueno

   - 60-69: Adecuado

   - 0-59: Insuficiente

## RÚBRICA

Objetivo: Evaluar la capacidad de los estudiantes para aplicar conceptos avanzados de programación y estructuras de datos en la creación de un sistema eficiente y efectivo de gestión y análisis de datos multidimensionales.

### Comentarios Adicionales:

   - Se espera que los proyectos sean entregados en la fecha y hora acordadas. Las entregas tardías pueden afectar la calificación.

   - Se alienta a los estudiantes a buscar retroalimentación y realizar revisiones durante el desarrollo para asegurar la calidad y funcionalidad del sistema.

   - El trabajo debe ser original y propio del equipo. El plagio resultará en una calificación de cero.

Esta rúbrica está diseñada para proporcionar una evaluación detallada y justa del proyecto final integrador, considerando varios aspectos críticos en el desarrollo de software, la aplicación de estructuras de datos, y la creación de interfaces de usuario.
