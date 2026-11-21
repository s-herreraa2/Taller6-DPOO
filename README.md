# Taller 6 – GUIs con Swing y Java2D

## Descripción

Esta aplicación permite llevar un registro de los restaurantes que se han visitado y de aquellos que le gustaría conocer al usuario. Desde la interfaz se puede consultar la información de cada restaurante, agregar nuevos y marcar su ubicación directamente en un mapa. Además, se puede visualizar todos los restaurantes registrados o filtrar la vista para mostrar únicamente los que ya se han visitado.

## Requisitos

- Java 11 o superior.
- Eclipse IDE.

## Instrucciones de ejecución

1. Clonar el repositorio.
2. Abrir el proyecto en Eclipse.
3. Buscar y abrir la clase `uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal`, ubicada en la carpeta `src`.
4. Correr la clase como un Java Application.

**Importante:** La aplicación utiliza imágenes almacenadas en la carpeta `imagenes/`, a las que accede mediante rutas relativas (`./imagenes/...`). Por esta razón, es necesario que el directorio de trabajo sea la carpeta raíz del proyecto. Eclipse utiliza esta configuración por defecto. Si se ejecuta desde otro directorio, es posible que algunos elementos gráficos, como el mapa y las estrellas de calificación, no se carguen correctamente.

## Uso de la aplicación

- **Nuevo:** Permite registrar un restaurante. Para hacerlo, primero se selecciona su ubicación haciendo clic sobre el mapa y luego se ingresan el nombre, la calificación y si ya ha sido visitado. Finalmente, se hace clic en **Crear restaurante** para guardarlo.
- **Ver todos:** Abre una vista del mapa en la que aparecen los restaurantes registrados. Los botones **Todos** y **Visitados** permiten cambiar entre la visualización de todos los restaurantes y la de aquellos que ya se han visitado.
- **Lista de restaurantes:** Al seleccionar un restaurante, se puede consultar su nombre, su calificación representada mediante estrellas y su estado de visita.

## Documentación

El diagrama de clases del proyecto se encuentra en `docs/Diagrama clases.png`.
