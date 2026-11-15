# Backend SneakerStore

API REST del catálogo de [SneakerStore](https://github.com/99nicolas/sneakerstore), construida con Spring Boot y PostgreSQL.

## Stack

- Java 17 · Spring Boot 3.5 (Web, Data JPA)
- PostgreSQL
- Docker (build multi-etapa con Maven)

## Endpoints

Base: `/api/sneakers`

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/sneakers` | Lista todas las zapatillas |
| GET | `/api/sneakers/{id}` | Obtiene una zapatilla por id |
| POST | `/api/sneakers` | Crea una zapatilla |
| PUT | `/api/sneakers/{id}` | Reemplaza una zapatilla |
| PATCH | `/api/sneakers/{id}/stock?cantidad=N` | Actualiza solo el stock |
| DELETE | `/api/sneakers/{id}` | Elimina una zapatilla |

Ejemplo de cuerpo:

```json
{
  "marca": "Nike",
  "modelo": "Air Max 90",
  "color": "Blanco",
  "precio": 119990,
  "stock": 10,
  "image": "https://...",
  "tallas": [40, 41, 42.5]
}
```

## Ejecutar

Configura la conexión a PostgreSQL en `src/main/resources/application.properties` (`spring.datasource.url`, `username`, `password`) y luego:

```bash
./mvnw spring-boot:run
```

Con Docker:

```bash
docker build -t sneaker-backend .
docker run -p 8080:8080 sneaker-backend
```

La API queda en `http://localhost:8080`.
