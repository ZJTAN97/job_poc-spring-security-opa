package com.poc.springsecurityopa.security;

import java.util.function.Supplier;

import com.poc.springsecurityopa.opa.OpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomOpaAuthorization implements AuthorizationManager<RequestAuthorizationContext> {

    @Autowired private OpaService opaService;

    @Override
    public AuthorizationDecision check(
            Supplier<Authentication> authentication, RequestAuthorizationContext object) {

        int decision = opaService.consult(authentication.get(), object.getRequest());

        return decision == 1 ? new AuthorizationDecision(true) : new AuthorizationDecision(false);
    }
}
