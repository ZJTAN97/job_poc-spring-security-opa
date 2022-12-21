# Proof Of Concept Work

- Proof Of Concept project with the integration of OPA (Open Policy Agent) and Spring Security
- Core idea is to make use of Spring Security `AuthorizationManager` to consult OPA to determine if the request should
  be authorized

# To Start

1. Start Spring Boot Application (along with containerized local MongoDB)
2. Start OPA server

```
cd /opa/rego
./opa.exe run --server .

```