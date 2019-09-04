package com.github.ubunfu.controller;

import com.github.ubunfu.entity.UserResponse;
import com.github.ubunfu.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<UserResponse> getUser(@PathVariable int id) {
        LOGGER.debug("Resolved API ...");
        return userService.getUser(id);
    }
}
