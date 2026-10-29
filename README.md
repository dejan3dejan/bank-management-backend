# Bank Management - Backend

REST API for managing banks, branches, services and service users. Built with Spring Boot and PostgreSQL as part of the *Razvoj veb aplikacija* (Web Application Development) course.

Frontend: [bank-management-frontend](https://github.com/dejan3dejan/bank-management-frontend)

## Stack

- Java, Spring Boot 3 (Web, Data JPA)
- PostgreSQL
- Maven

## Domain

| Entity | Description |
|---|---|
| `Banka` | Bank |
| `Filijala` | Bank branch, belongs to a bank |
| `KorisnikUsluge` | Service user (client) |
| `Usluga` | Service provided to a user at a branch |

The code follows a layered structure: `controllers` -> `services` -> `repositories` -> `models`.

## API

Each resource (`/banka`, `/filijala`, `/korisnik`, `/usluga`) exposes standard CRUD:

```
GET    /{resource}
GET    /{resource}/{id}
POST   /{resource}
PUT    /{resource}/{id}
DELETE /{resource}/{id}
```

Plus filtering endpoints, for example branches by bank, users by first or last name and by personal ID number, and services by branch, user, bank or date range.

## Running locally

1. Create a PostgreSQL database named `rva` on `localhost:5432`.
2. Adjust credentials in `src/main/resources/application.properties` if needed.
3. Run:

```bash
./mvnw spring-boot:run
```

The API starts on `http://localhost:8082`.
