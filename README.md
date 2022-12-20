# job_poc-spring-security-opa

# Open Policy Agent Notes

## 1. Understanding the Rego Language

```

# within each declaration {} follows the AND assignment
# between each declaration follows the OR assignment

hello {
  m := input.message # Assigning input.message to variable `m`
  m == "world" # check if m is equals to "world"
}

hello {
  m := input.message
  m == "hello"
}

# check if input.message == "hello" or "world", both will yield true
# if equal, returns true 

```