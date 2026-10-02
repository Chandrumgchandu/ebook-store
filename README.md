# E-Book Store

A full-stack learning project with a Java/Spring Boot backend, PostgreSQL persistence, and a Vite-based frontend. The repository is useful as application evidence that can be extended into a cloud-native delivery project.

## What this repo proves

- Spring Boot backend with REST controllers for books, categories, and health checks.
- JPA entities and repositories for PostgreSQL persistence.
- Vite frontend structure with API client separation.
- Maven and npm lock/wrapper files for reproducible local builds.
- Environment-driven backend database configuration instead of committed runtime secrets.
- Architecture notes in [`architecture.md`](architecture.md).

## Architecture

```text
Browser
   |
   v
Vite frontend
   |
   v
Spring Boot API
   |
   v
PostgreSQL
```

## Repository layout

```text
.
├── backend/       # Maven / Spring Boot API
├── frontend/      # Vite frontend
├── architecture.md
└── README.md
```

## Backend

```bash
cd backend
./mvnw test
./mvnw spring-boot:run
```

Expected environment variables:

```bash
SERVER_PORT=8080
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/ebookstore
SPRING_DATASOURCE_USERNAME=ebookuser
SPRING_DATASOURCE_PASSWORD=change-me
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_SHOW_SQL=false
```

## Frontend

```bash
cd frontend
npm ci
npm run dev
```

The frontend API client currently points at `http://localhost:8080/api` for local development.

## DevOps extension path

This repository is presented as a software engineering project with a clear path toward platform work. A stronger DevOps version would add:

- Dockerfiles for backend and frontend.
- Local compose stack for frontend, backend, and PostgreSQL.
- CI jobs for Maven tests, frontend lint/build, dependency audit, and image scanning.
- Kubernetes manifests with readiness/liveness probes and resource controls.
- Migration tooling before using shared databases.
- Metrics, structured logs, and deployment runbooks.

## Portfolio note

This is not claimed as a production deployment. It supports the portfolio by showing application code that can be delivered through the stronger CI/CD and Kubernetes patterns demonstrated in the DevOps-focused repositories.
