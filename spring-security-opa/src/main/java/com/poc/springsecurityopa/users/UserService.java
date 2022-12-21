package com.poc.springsecurityopa.users;

import com.poc.springsecurityopa.common.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRecordRepository userRecordRepository;

    public List<UserRecord> findAll() {
        return userRecordRepository.findAll();
    }

    public UserRecord findOne(String userId) {
        return userRecordRepository
                .findById(userId).orElseThrow(() ->
                        new RecordNotFoundException("Record " + userId + " does not exist"));
    }

    public UserRecord create(UserRecord userRecord) {
        return userRecordRepository.insert(userRecord);
    }

}
