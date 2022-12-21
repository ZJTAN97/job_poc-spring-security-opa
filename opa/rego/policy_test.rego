package policy_text

import data.example.authz.allow

test_allow_to_false_by_default {
    not allow
}

test_allow_if_not_admin {
    not allow with input as {
      "user": {
        "username": "docker",
        "roles": ["developer"]
      }
    }
}

test_allow_if_admin {
   allow with input as {
      "user": {
        "username": "docker_admin",
        "roles": ["admin"]
      }
   }
}

test_allow_if_get_on_public {
   allow with input as {
     "request": {
         "method": "GET",
         "path": "/public"
     }
   }
}

test_deny_if_not_get_on_public {
   not allow with input as {
     "request": {
         "method": "DELETE",
         "path": "/public"
     }
   }
}

test_deny_if_not_admin_and_get_not_public {
  not allow with input as {
    "request": {
        "method": "GET",
        "path": "/private"
    }
  }
}