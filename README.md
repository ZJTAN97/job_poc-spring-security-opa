# Proof Of Concept Work

- Proof Of Concept project with the integration of OPA (Open Policy Agent) and Spring Security
- Core idea is to make use of Spring Security `AuthorizationManager` to consult OPA to determine if the request should
  be authorized

# To Start

1. Start MongoDB and OPA Server container through docker-compose
2. Start Spring Boot application

```
docker-compose up -d
./mvnw spring-boot:run

```