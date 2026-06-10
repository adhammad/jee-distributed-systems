# JEE Distributed Systems - Spring Boot Projects

This repository contains two Spring Boot applications demonstrating JPA (Java Persistence API) with Spring Data JPA for building distributed systems.

## Projects Overview

### 1. AdilHammadHospital
A hospital management system with multiple entities and relationships.

**Tech Stack:**
- Spring Boot 3.2.3
- Spring Data JPA
- Spring Web
- H2 Database (in-memory)
- MySQL Connector
- Lombok
- Java 17

**Entities:**
- **Patient** - Patient information (name, date of birth, illness status)
- **Medecin** - Doctor information
- **RendezVous** - Appointments with status tracking
- **Consultation** - Medical consultations

**Relationships:**
- Patient ↔ RendezVous (One-to-Many)
- Medecin ↔ RendezVous (One-to-Many)
- RendezVous ↔ Consultation (One-to-One)

**API Endpoints:**
- `GET /patients` - List all patients

**Running the Application:**
```bash
cd AdilHammadHospital
./mvnw spring-boot:run
```

### 2. AdilHammadJpaSpringBoot
A simpler JPA demonstration project focusing on Patient management.

**Tech Stack:**
- Spring Boot 3.2.3
- Spring Data JPA
- Spring Web
- H2 Database (in-memory)
- MySQL Connector
- Lombok
- Java 17

**Entities:**
- **Patient** - Patient information (name, date of birth, illness status, score)

**API Endpoints:**
- `GET /patient` - List all patients

**Running the Application:**
```bash
cd AdilHammadJpaSpringBoot
./mvnw spring-boot:run
```

## Common Features

Both projects include:
- **H2 Console** - Access at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)
- **RESTful APIs** - JSON-based endpoints
- **JPA Repositories** - Automatic CRUD operations
- **Service Layer** - Business logic separation
- **Lombok** - Reduced boilerplate code

## Database Configuration

Both projects support:
- **H2** (default, in-memory for development/testing)
- **MySQL** (configured for production use)

## Building

```bash
# Build both projects
cd AdilHammadHospital && ./mvnw clean package
cd ../AdilHammadJpaSpringBoot && ./mvnw clean package
```

## Testing

```bash
# Run tests for both projects
cd AdilHammadHospital && ./mvnw test
cd ../AdilHammadJpaSpringBoot && ./mvnw test
```

## Requirements

- Java 17+
- Maven 3.6+ (or use included Maven wrapper)