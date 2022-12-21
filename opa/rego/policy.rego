package example.authz

default allow = false

allow {
    input.user.roles[_] == "admin" # iteration through roles, if there is admin, then its true
}

allow {
   startswith(input.request.path, "/public")
   input.request.method == "GET"
}
