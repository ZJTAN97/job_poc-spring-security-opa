package com.poc.springsecurityopa.opa;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpaRequest {

    private String name;

    private List<String> authorities;

    private String method;

    private String[] path;
}
