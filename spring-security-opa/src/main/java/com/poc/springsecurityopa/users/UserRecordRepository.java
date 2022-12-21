package com.poc.springsecurityopa.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecordRepository extends MongoRepository<UserRecord, String> {
}
