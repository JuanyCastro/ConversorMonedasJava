# 💱 Conversor de Monedas – Java 17

Proyecto desarrollado como parte de un desafío de programación para construir un conversor de monedas utilizando Java, HttpClient, Gson y consumo de API externas.

El objetivo principal fue crear una aplicación de consola capaz de consultar tasas de cambio reales, procesar respuestas JSON y permitir la conversión entre diferentes monedas en tiempo real.

---

## 🚀 Características principales

- Consumo de API ExchangeRate-API utilizando `HttpClient`.
- Procesamiento de datos JSON con **Gson**.
- Conversión entre varias monedas:  
  **USD ↔ ARS**, **USD → BRL**, **USD → CLP**, **USD → COP**.
- Interfaz por consola con menú interactivo.
- Historial de conversiones con fecha y hora.
- Manejo de errores y validación de opciones del usuario.

---

## 🛠️ Tecnologías utilizadas

- **Java 17**  
- **IntelliJ IDEA Community Edition**  
- **Gson 2.10.1+**  
- **ExchangeRate-API**  
- **java.net.http.HttpClient**  
- **java.time (LocalDateTime)**  

---

## 📂 Estructura del proyecto

```
src/main/java/conversorapp
│
├── Main.java               // Menú principal e interacción con el usuario
│
├── model
│   └── ExchangeRate.java   // Modelo para mapear datos del JSON
│
├── service
│   └── ApiService.java     // Consumo de la API (HttpClient, HttpRequest, HttpResponse)
│
└── util
    └── JsonParser.java     // Conversión JSON → Objeto Java usando Gson
```

---

## 🔑 Configuración inicial

1. Instalar **Java 17** o superior.  
2. Crear el proyecto en IntelliJ.  
3. Agregar la dependencia Gson:  
   - `File → Project Structure → Dependencies → + → Library → gson`
4. Obtener una API Key en:  
   https://www.exchangerate-api.com/  
5. Colocar tu clave en la clase `ApiService`:

```java
private static final String BASE_URL =
    "https://v6.exchangerate-api.com/v6/TU_API_KEY_AQUI/pair/";
```

---

## 🌐 Consumo de API

El proyecto utiliza el endpoint:

```
/pair/{MONEDA_BASE}/{MONEDA_DESTINO}
```

Ejemplo:

```
https://v6.exchangerate-api.com/v6/KEY/pair/USD/ARS
```

La API responde en formato JSON y los datos se convierten automáticamente al modelo `ExchangeRate` mediante Gson.

---

## 🧮 Funcionamiento del conversor

El usuario puede:

- Elegir la moneda origen y destino desde el menú interactivo.  
- Ingresar el monto a convertir.  
- Ver la conversión exacta mediante la tasa actualizada.  
- Consultar un historial de conversiones realizadas.

---

## 🖥️ Ejemplo de uso

```
======================================
     Bienvenido/a al Conversor
======================================
1) USD → ARS
2) ARS → USD
3) USD → BRL
4) USD → CLP
5) USD → COP
6) Ver historial de conversiones
7) Salir
Elija una opción: 1
Ingrese el monto a convertir: 1

======================================
 Conversión realizada con éxito
======================================
1.0 USD equivalen a:
1416.67 ARS
Tasa utilizada: 1416.67
Fecha y hora: 2025-11-24 20:50:17
======================================
```

---

## 🕒 Historial de conversiones

Ejemplo:

```
2025-11-24 20:54:29 → 20.0 USD = 75407.16 COP (tasa 3770.358)
```

---

## ▶️ Cómo ejecutar el programa

1. Abrir el proyecto en IntelliJ.  
2. Verificar dependencias (Gson).  
3. Ejecutar `Main.java`.  
4. Usar el menú desde la consola.

---

## 🎯 Objetivo educativo

Este proyecto permitió practicar:

- Programación orientada a objetos  
- Consumo de APIs REST  
- Manejo de JSON  
- Uso de HttpClient  
- Modularización de código  
- Manejo de fechas (`java.time`)  
- Interacción por consola (Scanner)  
- Buenas prácticas de documentación  

---

## 👤 Autor

Proyecto realizado por **Juan Castro** como parte del aprendizaje y práctica en desarrollo Java.
