# E-Book Store

A full-stack e-book store project with a Spring Boot backend, PostgreSQL persistence, and a Vite/React frontend.

The project is positioned as a supporting application delivery portfolio repo: it shows API structure, database-backed services, frontend/backend separation, environment-based configuration, and a path for DevOps hardening.

## Architecture

```text
React / Vite frontend
        |
        v
Spring Boot REST API
        |
        v
PostgreSQL database
```

More detail is available in [architecture.md](architecture.md).

## What is included

```text
backend/                 Spring Boot API
frontend/                Vite/React frontend
frontend/.env.example    Frontend API URL example
architecture.md          Architecture and delivery notes
README.md                Project overview and run guide
```

## Backend configuration

The backend database connection is environment-driven.

| Variable | Purpose | Default |
|---|---|---|
| `DB_HOST` | PostgreSQL host | `localhost` |
| `DB_PORT` | PostgreSQL port | `5432` |
| `DB_NAME` | Database name | `ebookstore` |
| `DB_USER` | Database user | `postgres` |
| `DB_PASSWORD` | Database password | `postgres` |

## Frontend configuration

The frontend API base URL is configured through Vite:

```bash
cp frontend/.env.example frontend/.env
```

Default local value:

```text
VITE_API_BASE_URL=http://localhost:8080/api
```

## Run locally

Start PostgreSQL and create the database expected by the backend.

Backend:

```bash
cd backend
./mvnw test
./mvnw spring-boot:run
```

Frontend:

```bash
cd frontend
npm install
npm run dev
```

## DevOps / Platform evidence

- Environment-based backend database configuration
- Configurable frontend API endpoint
- Maven wrapper for repeatable backend builds
- npm lock file for repeatable frontend installs
- Backend health endpoint
- Architecture documentation
- Cleanup of unused starter assets and placeholder code

## Operational notes

- Keep real database credentials outside source control.
- Use `.env` locally and platform secrets in hosted environments.
- Add Docker Compose when pairing the backend with a local PostgreSQL service.
- Add CI before using this as a serious deployment example.

## Portfolio role

This repository is a supporting full-stack project. It helps demonstrate application delivery fundamentals and configuration hygiene. For stronger DevOps pipeline evidence, pair it with:

- [employee-portal](https://github.com/Chandrumgchandu/employee-portal)
- [todo_app_jenkins](https://github.com/Chandrumgchandu/todo_app_jenkins)
- [devops-lab](https://github.com/Chandrumgchandu/devops-lab)
