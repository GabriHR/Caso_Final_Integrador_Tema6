# Caso Final Integrador Tema 6: Sistema de Gestión y Análisis de Datos Multidimensionales

Caso Final Integrador del Tema 6 desarrollado por Gabriel Hernanz Rodríguez.

LINK: https://github.com/GabriHR/Caso_Final_Integrador_Tema6.git


## ÍNDICE

- DESCRIPCIÓN
- MÓDULOS
   - 1. Gestión de Datos Dinámicos
   - 2. Análisis y Organización de Información
   - 3. Mapas y Asociación de Datos
   - 4. Indexación y Visualización de Archivos
- CRITERIOS EVALUACIÓN
- RÚBRICA

# DESCRIPCIÓN

El proyecto consistirá en el desarrollo de una aplicación de software que integre varias estructuras de datos, algoritmos de ordenación y búsqueda, y métodos interactivos de entrada y salida de datos. Los estudiantes aplicarán conceptos avanzados de programación y estructuras de datos para crear una herramienta versátil y eficiente.

# MÓDULOS

### 1. Gestión de Datos Dinámicos (Gestion_Datos_Dinamicos)
Consiste en una interfaz gráfica que le permita al usuario escoger con que tipo de dato trabajar, listas de números o matrices, listas de datos reales o pares de números enteros.

*Clases:*
   - La clase Pareja es una clase simple en Java que representa un par de números enteros. Cada objeto Pareja tiene dos variables de instancia, primero y segundo, que se establecen a través del constructor de la clase. La clase proporciona métodos getter para recuperar estos valores
   - La clase ListaDatos es una clase en Java que representa una lista de datos reales y una lista de objetos Pareja. Esta clase extiende Observable, lo que significa que puede tener observadores que son notificados cuando cambia el estado de ListaDatos. Proporciona métodos para agregar elementos a estas listas y recuperar estas listas. Además, notifica a los observadores cuando se agregan elementos a las listas.
   - La clase Gestion_Datos_Window es una clase en Java que representa una ventana de interfaz gráfica de usuario (GUI) que permite al usuario interactuar con una lista de datos reales y una lista de objetos Pareja. Configura la interfaz gráfica de usuario y establece los oyentes de eventos para los botones y campos de texto. Cuando se presiona el botón "Agregar datos", se recogen los datos de los campos de texto, se agregan a la lista de datos y se actualiza el área de texto.

### 2. Análisis y Organización de Información

En el módulo correspondiente al packager Analisis_Organizacion_Informacion, existe el código necesario para gestionar las ventas y transacciones bancarias. En el se controlan/manejan la fecha de dicha transacción, el cliente que la realiza y su nombre, el tipo de producto que es comprado y la cantidad que se compra él.

