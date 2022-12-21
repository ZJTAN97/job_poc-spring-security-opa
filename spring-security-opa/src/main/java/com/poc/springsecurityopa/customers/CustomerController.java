package com.poc.springsecurityopa.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerMapper customerMapper;
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> findAll() {
        List<CustomerRecord> userRecords = customerService.findAll();
        return customerMapper.toDto(userRecords);
    }

    @GetMapping("/{id}")
    public CustomerResponse findOne(@PathVariable("id") String userId) {
        CustomerRecord userRecord = customerService.findOne(userId);
        return customerMapper.toDto(userRecord);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest userRequest) {
        CustomerRecord createdUserRecord = customerService.create(customerMapper.toDomainObject(userRequest));
        CustomerResponse createdUserResponse = customerMapper.toDto(createdUserRecord);

        UriComponents uriComponents = UriComponentsBuilder
            .fromPath("/api/v1/users/{userId}")
            .buildAndExpand(createdUserResponse.id());

        return ResponseEntity.created(uriComponents.toUri())
            .contentType(MediaType.APPLICATION_JSON)
            .body(customerMapper.toDto(createdUserRecord));
    }

}
