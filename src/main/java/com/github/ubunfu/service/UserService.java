package com.github.ubunfu.service;

        import com.github.ubunfu.entity.UserResponse;
        import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponse> getUser(int id);
}
