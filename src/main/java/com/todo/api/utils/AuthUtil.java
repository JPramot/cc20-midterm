package com.todo.api.utils;

import com.todo.api.entity.User;
import com.todo.api.exceptionHandler.NotFoundExc;
import com.todo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    @Autowired
    private UserRepository userRepository;

    public User loginUser() {
        Authentication authentication = getAuthentication();
        String username = authentication.getName();
        if(username.equals("anonymousUser")) {
            return null;
        } else {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundExc("User", "username", username));
        }
    }

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
