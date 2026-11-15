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

## Configuración

Las credenciales de la base de datos **no** se guardan en el repositorio. Se leen de variables de entorno:

| Variable | Ejemplo | Obligatoria |
|---|---|---|
| `DB_URL` | `jdbc:postgresql://host:5432/basedatos` | Sí |
| `DB_USERNAME` | `usuario` | Sí |
| `DB_PASSWORD` | `********` | Sí |
| `PORT` | `8080` | No (8080 por defecto) |
| `SHOW_SQL` | `true` | No (false por defecto) |

## Ejecutar

```bash
export DB_URL=jdbc:postgresql://host:5432/basedatos
export DB_USERNAME=usuario
export DB_PASSWORD=tu_contraseña
./mvnw spring-boot:run
```

Con Docker:

```bash
docker build -t sneaker-backend .
docker run -p 8080:8080 \
  -e DB_URL=jdbc:postgresql://host:5432/basedatos \
  -e DB_USERNAME=usuario \
  -e DB_PASSWORD=tu_contraseña \
  sneaker-backend
```

La API queda en `http://localhost:8080`.
