Tutorial project using Spring Webflux Security
================================


## using the following technologies::
 - Spring Boot 3
 - Spring Security (JWT)
 - Spring WebFlux
 - Spring Data R2DBC
 - MapStruct
 - PostgreSQL
 - Flyway


## Running the application locally
- Install PostgreSQL

## Create БД
```sql
CREATE DATABASE "webfluxsecurity";
```

## Set correct values in application.yml
```sql
spring:r2dbc:username
```

```sql
spring:r2dbc:password
```

# CURL requests:

## 1. User registration
```bash
curl --location 'http://localhost:8083/api/v1/auth/register' \
--header 'Content-Type: application/json' \
--data '{
    "username": "sez",
    "password": "test",
    "first_name": "Evgeny",
    "last_name": "Evgeny"
}'
```

Simple answer:
```json
{
  "id": 1,
  "username": "sez",
  "role": "USER",
  "first_name": "Evgeny",
  "last_name": "Evgeny",
  "enabled": true,
  "created_at": "2024-01-08T14:53:32.36094",
  "updated_at": "2024-01-08T14:53:32.360954"
}
```

## 2. User authentication
```bash
curl --location 'http://localhost:8083/api/v1/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "sez",
    "password": "test"
  }'
```

Simple answer:
```json
{
  "user_id": 1,
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4Iiwicm9sZSI6IlVTRVIiLCJpc3MiOiJtZSIsImV4cCI6MTcwNDgwMTM1NSwiaWF0IjoxNzA0Nzk3NzU1LCJqdGkiOiJjNGZjNjAwYS0wZTNiLTRjOTQtOTcyOS04ODczMDJmYjljYjIiLCJ1c2VybmFtZSI6InNleiJ9.BRyM37EfTfSoqh8S-gApm_uEz3ket1HgBXGb-DdCoOI",
  "issued_at": "2024-01-08T11:53:56.390+00:00",
  "expires_at": "2024-01-08T12:53:56.390+00:00"
}
```

## 3. Retrieving user data using the token obtained in the previous request

```bash
curl --location 'http://localhost:8083/api/v1/auth/info' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4Iiwicm9sZSI6IlVTRVIiLCJpc3MiOiJtZSIsImV4cCI6MTcwNDgwMTM1NSwiaWF0IjoxNzA0Nzk3NzU1LCJqdGkiOiJjNGZjNjAwYS0wZTNiLTRjOTQtOTcyOS04ODczMDJmYjljYjIiLCJ1c2VybmFtZSI6InNleiJ9.BRyM37EfTfSoqh8S-gApm_uEz3ket1HgBXGb-DdCoOI'
```

Simple answer:
```json
{
  "id": 1,
  "username": "sez",
  "role": "USER",
  "first_name": "Evgeny",
  "last_name": "Evgeny",
  "enabled": true,
  "created_at": "2024-01-08T14:02:37.248466",
  "updated_at": "2024-01-08T14:02:37.248482"
}
```
