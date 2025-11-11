#  Challenge Conversor de Monedas

Proyecto desarrollado como parte del **Challenge de Alura Latam - Backend con Java**.  
El objetivo principal es construir una aplicación que permita **convertir diferentes monedas en tiempo real** consumiendo una API externa.


##  Descripción del Proyecto

El **Conversor de Monedas** es una aplicación de consola escrita en **Java**, que utiliza la **Exchange Rate API** para obtener las tasas de cambio actualizadas entre distintas divisas.  
El usuario puede elegir entre varias opciones del menú para realizar conversiones y obtener el resultado de forma inmediata.


##  Tecnologías utilizadas

-  **Java 25+**
-  **Maven** (gestor de dependencias)
-  **ExchangeRate API** (para obtener tasas de cambio)
-  **Gson** (para parsear respuestas JSON)


##  Funcionalidades principales

- Menú interactivo con opciones de conversión:
  - USD ↔ ARS  
  - USD ↔ BRL  
  - USD ↔ COP  
- Solicitudes HTTP a la API de tasas de cambio.
- Manejo de errores y validaciones básicas.
- Resultados mostrados con formato claro y amigable.


##  Estructura del proyecto

Challenge-Conversor-de-Monedas/
├── pom.xml
└── src/
└── main/
├── java/
│ └── com/
│ └── graciela/
│ └── conversor/
│ ├── Main.java
│ └── ExchangeRateService.java
└── resources/


##  API utilizada

Se utilizó la [**ExchangeRate API**](https://www.exchangerate-api.com/) para obtener los valores de cambio entre monedas.  
Para poder ejecutarlo, es necesario registrar una cuenta gratuita y obtener una **API Key personal**.


##  Ejecución del programa

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Graciela-Murga/Challenge-Conversor-de-Monedas.git

2. Abre el proyecto en IntelliJ IDEA (o tu IDE preferido).
3. Asegúrate de tener configurado Java 17+.
4. Coloca tu API Key en la clase ExchangeRateService:
   private static final String API_KEY = "TU_API_KEY_AQUI";
5. Ejecuta la clase Main.java y selecciona una opción del menú.


---------------------------------------------------------------------------------------------------------------------------------------------

##  Versión web (bonus+)

Además de la aplicación de consola, este repositorio incluye una **versión web** del conversor, construida con **HTML, CSS y JavaScript**, utilizando la misma API de tipos de cambio.

El archivo se encuentra en:

`/web/index.html`

Para probarla de forma local:

1. Clona el proyecto o descarga el ZIP.
2. Asegúrate de colocar tu **API Key** en el archivo `web/index.html`.
3. Abre `web/index.html` en tu navegador favorito.

> Esta versión web no es parte obligatoria del challenge, pero la desarrollé como mejora adicional del proyecto.


Autora
👩‍💻 Graciela Murga
Desarrolladora Backend en formación — Alura Latam
📧 gracielamurga617@gmail.com


Proyecto creado con fines educativos dentro del programa Oracle Next Education + Alura Latam.








