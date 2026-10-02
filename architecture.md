# E-Book Store Architecture

## Current system

```text
User browser
  |
  v
Vite frontend
  |
  | HTTP / JSON
  v
Spring Boot backend
  |
  | JPA repositories
  v
PostgreSQL database
```

## Components

| Component | Path | Responsibility |
|---|---|---|
| Frontend | `frontend/` | Browser UI built with Vite and React tooling. |
| API backend | `backend/` | Spring Boot REST API for book and category resources. |
| Persistence | `backend/src/main/java/.../repository` | Spring Data repositories backed by PostgreSQL. |
| Configuration | `backend/src/main/resources/application.properties` | Environment-driven datasource and runtime settings. |

## Runtime configuration

The backend accepts these environment variables:

| Variable | Purpose |
|---|---|
| `SERVER_PORT` | Backend HTTP port, default `8080`. |
| `SPRING_DATASOURCE_URL` | PostgreSQL JDBC URL. |
| `SPRING_DATASOURCE_USERNAME` | Database username. |
| `SPRING_DATASOURCE_PASSWORD` | Database password. |
| `SPRING_JPA_HIBERNATE_DDL_AUTO` | Schema management mode, default `update` for local development. |
| `SPRING_JPA_SHOW_SQL` | SQL logging switch, default `false`. |

## DevOps readiness

This repo is application-focused today. To promote it into a stronger platform engineering project, add:

- Backend and frontend Dockerfiles.
- A compose file for local PostgreSQL, backend, and frontend.
- CI jobs for Maven tests, frontend lint/build, dependency audit, and image scanning.
- Kubernetes Deployment, Service, ConfigMap, Secret template, readiness/liveness probes, and resource requests/limits.
- Migration tooling such as Flyway or Liquibase before using persistent shared environments.
- Observability signals for request latency, error rate, health, and database connectivity.

## Operational notes

- Do not commit real database passwords; use environment variables or platform secrets.
- Keep `ddl-auto=update` limited to local/demo environments.
- Use explicit database migrations for shared or production-like deployments.
- Prefer immutable image tags and rollout verification when containerizing this app.
