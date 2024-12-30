# 🌱 EcoMarket AI 🌱  
**Un marketplace impulsado por inteligencia artificial para productos ecológicos.**  

## 🚀 Descripción del Proyecto  
EcoMarket AI es una plataforma innovadora que utiliza **Java con Spring Boot** y la integración de **OpenAI** para ofrecer un marketplace de productos ecológicos. Con la ayuda de inteligencia artificial, este proyecto sugiere productos ecológicos personalizados y sostenibles a los usuarios, promoviendo un estilo de vida consciente con el medio ambiente.

## 🛠️ Tecnologías y Herramientas Utilizadas  

### Backend  
- **Java**: Lenguaje principal del proyecto.  
- **Spring Boot**: Framework robusto para la creación de aplicaciones web, con módulos clave como:  
  - **Spring Web**: Para la creación de APIs REST.  
  - **Spring Data JPA**: Para la gestión de bases de datos relacionales.  
  - **Spring Security**: Para la autenticación y autorización.  
- **Swagger/OpenAPI**: Generación automática de documentación interactiva para nuestras APIs.  
- **OpenAI API**: Para generar descripciones y recomendaciones de productos ecológicos utilizando inteligencia artificial.  

### Base de Datos  
- **asd**:

### Infraestructura  
- **Docker**: Para la contenedorización y despliegue fácil.  


### Herramientas de Desarrollo  
- **Maven**: Gestión de dependencias y construcción del proyecto.  
- **Lombok**: Reducción del código boilerplate en entidades y DTOs.  
- **MapStruct**: Simplificación de la conversión entre entidades y DTOs.  

## 🌟 Características Principales  
1. **Recomendaciones Personalizadas**:  
   La integración con OpenAI permite generar recomendaciones inteligentes basadas en las preferencias del usuario.  
2. **Productos 100% Ecológicos**:  
   Catálogo de productos seleccionados por su impacto positivo en el medio ambiente.  
3. **Gestión Eficiente**:  
   CRUD para productos, usuarios y órdenes, con validaciones robustas y uso de DTOs para una comunicación eficiente entre capas.  
4. **Documentación Interactiva**:  
   Swagger UI permite a los desarrolladores explorar las APIs de forma visual e interactuar con ellas.  

## 📜 Documentación y API  

### Swagger UI  
Para acceder a la documentación:  
1. Inicia la aplicación.  
2. Ve a: `http://localhost:8080/swagger-ui.html`.  
3. Explora y prueba las rutas disponibles.

### Endpoints Clave  
- **Productos**:  
  - `GET /api/products`: Lista todos los productos.  
  - `POST /api/products`: Crea un nuevo producto.  
- **Recomendaciones AI**:  
  - `GET /api/products/recommendations`: Genera recomendaciones basadas en el perfil del usuario.  

## 🛠️ Configuración del Proyecto  

### Requisitos Previos  
- **Java 17** o superior.  
- **Maven** instalado.  


### Pasos para Configuración Local  
1. Clonar el repositorio:  
   ```bash  
   git clone https://github.com/tu_usuario/ecomarket-ai.git  
   cd ecomarket-ai  
   ```
2. Configurar las variables de entorno:
```bash  
OPENAI_API_KEY: Clave de acceso a OpenAI.
SPRING_DATASOURCE_URL: URL de la base de datos.
```
3. Construir y ejecutar la aplicación:

	```bash
	mvn clean install  
	mvn spring-boot:run  
	```

##🚀 Despliegue
Crear una imagen Docker:
```

```