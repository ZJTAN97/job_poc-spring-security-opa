package authz

default allow = false

allow {
    input.authorities[_] == "ROLE_ADMIN" # iteration through roles, if there is admin, then its true
}

allow {
   input.authorities[_] == "ROLE_DEVELOPER"
   input.path[_] == "customers"
   input.method == "GET"
}
