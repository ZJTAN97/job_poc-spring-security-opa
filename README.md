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


# Implementation details

Dependencies Details
- Spring Boot 2.7.6
- Spring Security 5.8.x

<br>

## Some introduction

- Moving forward from Spring Security 5.7, there are quite a few changes and most noticeably `WebSecurityConfigurerAdapter` has been deprecated in favour of using `@EnableWebSecurity`
- The way we define handle our custom Authorizations will be different as well
- Spring Team recommends us to introduce an AuthorizationManager that invokes an `AccessDecisionManager` or `AccessDecisionVoter`.

<br>

## Authentication for this PoC
- It just uses a simple in memory authentication as the main purpose of this PoC is to test out the integration of OPA for custom authorizations.
- There will be 2 users created; `admin` and `user`.

admin credentials and authorities
- username: admin
- password: password
- authorities: ROLE_ADMIN

user credentials and authorities
- username: user
- password: password
- authorities: ROLE_DEVELOPER


<br>

## Authorization for this PoC
- As mentioned, authorization will be handled and defined by policies written in Rego from Open Policy Agent.

<br>

The policy is as followed:

1. For ADMIN
   - Access to POST `/customers`
   - Access to GET `/customers`

2. For Developers
   - Access to GET `/customers`

<br>

For OPA to be integrated with Spring Security Authorization Manager, there are 2 main components written
- `CustomOpaAuthorization` which implements Spring Security `AuthorizationManager`
- `OpaService` which has a single method `consult` to send request to OPA to consult on whether the following user is authorized to access the different resources.