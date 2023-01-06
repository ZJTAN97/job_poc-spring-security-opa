
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


## 2. Running OPA (3 ways)

```

# 1. eval (quick way to evaluate your policies)
./opa.exe eval --format raw --data policy.rego --input input.json 'data.<packagename>.<variable_you_testing>'

# 2. test (unit testing provided by OPA)
./opa.exe test ../


# 3. start server and apply written policies (through REST API)
./opa.exe run --server ../

```
