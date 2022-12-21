package com.poc.springsecurityopa.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping
    public List<UserResponse> findAll() {
        List<UserRecord> userRecords = userService.findAll();
        return userMapper.toDto(userRecords);
    }

    @GetMapping("/{id}")
    public UserResponse findOne(@PathVariable("id") String userId) {
        UserRecord userRecord = userService.findOne(userId);
        return userMapper.toDto(userRecord);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        UserRecord createdUserRecord = userService.create(userMapper.toDomainObject(userRequest));
        UserResponse createdUserResponse = userMapper.toDto(createdUserRecord);

        UriComponents uriComponents = UriComponentsBuilder
            .fromPath("/api/v1/users/{userId}")
            .buildAndExpand(createdUserResponse.id());

        return ResponseEntity.created(uriComponents.toUri())
            .contentType(MediaType.APPLICATION_JSON)
            .body(userMapper.toDto(createdUserRecord));
    }

}
