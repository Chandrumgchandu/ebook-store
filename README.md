# E-Book Store

A full-stack software engineering project with a Java/Spring backend and a modern JavaScript frontend.

## Architecture

```text
Web client
   |
   v
Frontend application
   |
   v
Spring backend
   |
   v
Application persistence
```

## Repository layout

```text
.
├── backend/       # Maven / Spring application
├── frontend/      # Vite-based frontend
├── architecture.md
└── README.md
```

## Backend

The backend is a Maven-managed Java application with source under `backend/src`. The Maven wrapper is included, making the project reproducible without requiring a globally installed Maven version.

```bash
cd backend
./mvnw test
./mvnw spring-boot:run
```

## Frontend

The frontend uses a Node.js toolchain with Vite and includes a dependency lockfile for reproducible installs.

```bash
cd frontend
npm ci
npm run dev
```

## Engineering focus

This repository demonstrates separation of frontend and backend concerns, reproducible dependency management, and a full-stack application structure that can be extended with containerization, automated testing, CI/CD, infrastructure provisioning, and cloud deployment.

## DevOps extension path

A production-oriented evolution of this project would include:

- Docker images for frontend and backend
- CI validation and automated tests
- Container image scanning
- Registry publishing
- Infrastructure as Code
- Kubernetes deployment manifests
- Health probes and resource controls
- Metrics, logs, and alerting

This repository is presented as a software engineering project; the DevOps portfolio projects on this profile demonstrate those delivery and operations patterns separately.
