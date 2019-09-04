package com.github.ubunfu.service;

import com.github.ubunfu.entity.UserResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private WebClient webClient;

    /**
     * Get a single User.
     * @return A Mono of {@link UserResponse}
     * @param id ID of a user
     */
    @Override
    public Mono<UserResponse> getUser(int id) {
        LOGGER.warn("Getting one user from the API ...");
        Mono<UserResponse> resp = webClient.get()
                .uri(String.format("/api/users/%d", id))
                .retrieve()
                .bodyToMono(UserResponse.class);
        resp.subscribe(userResponse -> LOGGER.warn(userResponse.toString()));
        return resp;
    }
}
