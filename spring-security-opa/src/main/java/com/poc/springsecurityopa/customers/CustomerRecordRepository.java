package com.poc.springsecurityopa.customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRecordRepository extends MongoRepository<CustomerRecord, String> {
}
