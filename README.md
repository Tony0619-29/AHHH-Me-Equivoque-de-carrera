# **AHH ME equivoque de Carrera** 🎓  
> _Encuentra la carrera ideal según tus actitudes, aptitudes, valores, habilidades y preferencias._

---

## 📋 **Descripción**  
AHH ME equivoque de Carrera es una herramienta diseñada para ayudar a los estudiantes a elegir la carrera universitaria adecuada. A través de un sistema basado en datos,  como actitudes, aptitudes, valores, habilidades y preferencias para ofrecer recomendaciones personalizadas. Incluye opciones de universidades como el IPN, UNAM, UAM y algunas privadas, ayudando a los estudiantes a tomar decisiones informadas y reducir la tasa de deserción universitaria.

---

## 🚀 **Características Principales**  
- 🧠 Evaluación integral basada en:
  - Actitudes y valores personales.
  - Aptitudes y habilidades específicas.
  - Preferencias de estudio y área de interés.
- 🎓 Recomendación de carreras según las universidades seleccionadas (IPN, UNAM, UAM, privadas).
- 📊 Sistema de puntuación personalizado basado en perfiles.

---

## 🛠️ **Tecnologías Utilizadas**  
- **PostgreSQL**: Base de datos relacional para almacenar perfiles de estudiantes, carreras y universidades de manera estructurada y eficiente  
- **Spring Framework**: Framework de Java utilizado para construir el backend de la API, incluyendo controladores REST, servicios y lógica empresarial.
- **Java**: Lenguaje principal para la lógica del backend, proporcionando una base sólida y escalable.
- **Postman**: Herramienta para pruebas de la API, facilitando la validación y depuración de los endpoints. 
- **Docker**: Contenedores para simplificar la configuración y despliegue de la aplicación, garantizando un entorno consistente.

---


## 🎯 **Objetivos del Proyecto**  
1. Ayudar a los estudiantes a identificar carreras que se alineen con sus habilidades y valores.  
2. Reducir la deserción universitaria mediante decisiones informadas.  
3. Ofrecer una herramienta gratuita y accesible a estudiantes en todo México.
4. Evaluar intereses y aptitudes, implementado cuestionarios o pruebas para identificar habilidades, intereses y valores relevantes
5. Proveer recomendaciones personalizadas, basado en las respuestas del usuario en el test
6. Ampliar el alcance de la orientación vocacional, ofreciendo apoyo a estudiantes que no tengan acceso a consejería profesional en sus escuelas.
7. Contribuir al desarrollo profesional temprano, a traves del autoconocimiento de sus preferencias academicas para su futuro universitario.

---
## ✨ **Autores y Colaboradores**  

| <img src="https://github.com/Tony0619-29.png" width="100" /> | <img src="https://github.com/gramos-GH.png" width="100" /> | <img src="https://github.com/AbnerR72.png" width="100" /> | <img src="https://github.com/EsmeraraldaFlores.png" width="100" /> | <img src="https://github.com/Yulsuwu.png" width="100" /> |<img src="https://github.com/Andu890.png" width="100" />|
|:---:|:---:|:---:|:---:|:---:|:---:|
| **[Antonio Medina Montoya](https://github.com/Tony0619-29)** | **[Gaethan Ramos Medina](https://github.com/gramos-GH)** | **[Abner Ruiz Santiago](https://github.com/AbnerR72)** | **[Rosa Esmeralda Flores Harrison](https://github.com/EsmeraraldaFlores)** | **[Julio Cesar Medrano Reyes](https://github.com/Yulsuwu)** |**[Andres Daniel García Brizuela](https://github.com/Andu890)**|
| Creador | Creador | Creador | Creadora | Creador |Creador|

---
## 💾**Diseño de La base de datos** 
<img src="AHHHMeEquivoqueDeCarrera_Diseño.jpg" alt="Diseño De Base de Datos" width="600">

---
## **Importante**
  Crea la base de datos chochos para que el proyecto pueda ser creado correctamente 

  ```psql -U postgres```
```sql
CREATE USER chochos WITH PASSWORD 'chochos';
CREATE DATABASE chochos OWNER chochos;
```
---
## 📄 **Descripción de la base de datos**
Para la realización de este proyecto se requirió la realización de una base de datos que pudiera almacenar los datos de los test que realizan nuestros usuarios diariamente. Para fines de este proyecto se identidicaron las siguientes entidades:

1. **Usuario**     (Son los usuarios que realizan los test.)
2. **Test**        (Son los test que los usuarios realizan.)
3. **Carrera**     (Son las carreras que seran sugeridas con los resultados del test, siendo estas publicas o privadas.)
4. **Universidad** (Son las universidades donde se encuentran esas carreras.)
5. **Pregunta**    (Es cada una de las preguntas que conforman un test realizado por el usuario.)
6. **Respuesta**   (Corresponde a cada una de las respuestas a las preguntas que se encuentran en un test.)
7. **Resultado**   (Es el producto obtenido por cada estudiante en su examen.)
8. **TestxPregunta** (Tabla transitiva ubicada entre la entidad TEST y PREGUNTA por cuestiones de relaciones).
---
📄 **Interrelaciones entre entidades**
1. Un **USUARIO** debe realizar muchos TEST.
2. Un **TEST** debe ser realizado por un solo USUARIO.
3. Un **TEST** debe sugerir una CARRERA.
4. Una **CARRERA** debe ser segurida por varios TEST.
5. Una **CARRERA** debe pertenecer a una UNIVERSIDAD.
6. Una **UNIVERSIDAD** debe tener muchas CARRERAS.
7. Una **PREGUNTA** debe tener muchas RESPUESTAS.
8. Una **RESPUESTA** debe tener una PREGUNTA.
9. Una **RESPUESTA** debe generar un RESULTADO.
10. Un **RESULTADO** debe ser generado por muchas RESPUESTAS.
---
📄 **Atributos de las entidades de la base de datos**
1. **Usuario**:
     - a) **idUsuario**: identificador único del usuario registrado.
     - b) **nombre**: nombre del usuario registrado.
     - c) **paterno**: apellido paterno del usuario registrado.
     - d) **materno**: apellido materno del usuario registrado.
     - e) **correo**: correo electrónico del usuario registrado.
2. **Test**:
     - a) **idTest**: identificador único de cada test en cuestión.
     - b) **nombre**: nombre del test.
     - c) **descripción**: información breve que indica el contenido y propósito del test.
     - e) **fechaCreacion**: fecha de creación del test que está realizando el usuario.
     - f) **idUsuario**: llave foránea que conecta TEST con USUARIO.
3. **Carrera**:
     - a) **idCarrera**: identificador único de cada carrera en cuestión.
     - b) **nombre**: nombre de la carrera.
     - c) **duración**: duración de la carrera (años, semestres, trimestres o cuatrimestres).
     - d) **descripcion**: descripcion de la carrera.
     - e) **idUniversidad**: llave foránea que conecta CARRERA con UNIVERSIDAD.
     - f) **idTest**: llave foránea que conecta TEST con CARRERA.
5. **Universidad**:
     - a) **idUniversidad**: identificador único de cada universidad
     - b) **Nombre**: Nombre de la universidad
     - c) **Tipo**: tipo de la universidad (Publica o Privada)
     - d) **Pagina web**: URL de la pagina web de la universidad
7. **Pregunta**:
     - a) **idPregunta**: identificador único de cada pregunta
     - b) **pregunta**: pregunta del test
     - c) **tipo**: el tipo de la pregunta (aptitud, interes, habilidad, academica)
9. **Respuesta**:
     - a) **idRespuesta**: identificador único de cada respuesta
     - b) **respuesta**: respuesta de cada pregunta
     - c) **fechaRespuesta**: fecha en la que se registro la respuesta
     - d) **idPregunta**: llave foránea hacia la entidad Pregunta
11. **Resultado**:
     - a) **idResultado**: identificador unico de cada resultado que se obtenga
     - b) **puntaje**: puntaje que se obtuvo en total 
     - c) **fecha**: fecha en que se realizo el test
     - d) **resultado**: resultado del test 
     - e) **area**: area de mayor afinidad (Matematicas/Biologicas/Sociales/Artes)
     - f) **descripcion**: descripcion adicional al resultado
     - g) **idRespuesta**: llave foránea hacia la entidad respuestas
