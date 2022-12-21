package com.poc.springsecurityopa.customers;

import com.poc.springsecurityopa.common.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRecordRepository customerRecordRepository;

    public List<CustomerRecord> findAll() {
        return customerRecordRepository.findAll();
    }

    public CustomerRecord findOne(String customerId) {
        return customerRecordRepository
                .findById(customerId).orElseThrow(() ->
                        new RecordNotFoundException("Record " + customerId + " does not exist"));
    }

    public CustomerRecord create(CustomerRecord userRecord) {
        return customerRecordRepository.insert(userRecord);
    }

}
