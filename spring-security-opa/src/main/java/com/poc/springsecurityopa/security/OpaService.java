package com.poc.springsecurityopa.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poc.springsecurityopa.opa.OpaRequest;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpaService {

    private static final String endpoint = "http://localhost:8181/v1/data/authz/allow";

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public int consult(Authentication authentication, HttpServletRequest request) {
        String name = authentication.getName();
        List<String> authorities =
                authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList();

        String method = request.getMethod();
        String[] path = request.getRequestURI().replaceAll("^/|/$", "").split("/");

        ObjectNode requestNode = objectMapper.createObjectNode();
        requestNode.set(
                "input",
                objectMapper.valueToTree(
                        OpaRequest.builder()
                                .name(name)
                                .authorities(authorities)
                                .method(method)
                                .path(path)
                                .build()));

        log.info("OPA Authorization request: \n " + requestNode.toPrettyString());

        JsonNode responseNode =
                Objects.requireNonNull(
                        restTemplate.postForObject(endpoint, requestNode, JsonNode.class));

        log.info("OPA Authorization response: \n " + responseNode.toPrettyString());

        if (responseNode.has("result") && responseNode.get("result").asBoolean()) {
            return 1;
        }
        return 0;
    }
}
