package policy_text

import data.authz.allow

test_allow_to_false_by_default {
    not allow
}

test_allow_if_not_admin {
    not allow with input as {
        "name": "docker",
        "authorities": ["ROLE_DEVELOPER"]
    }
}

test_allow_if_admin {
   allow with input as {
       "name": "kubernetes",
       "authorities": ["ROLE_ADMIN"]
   }
}

test_allow_if_get_on_users {
   allow with input as {
       "method": "GET",
       "path": ["api", "v1", "customers"]
   }
}

test_deny_if_not_get_on_users {
   not allow with input as {
       "method": "PUT",
       "path": ["api", "v1", "customers"]
   }
}
