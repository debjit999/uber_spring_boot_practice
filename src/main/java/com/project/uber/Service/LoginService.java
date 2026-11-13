package com.project.uber.Service;
import com.project.uber.Dto.LoginRequest;
import com.project.uber.Dto.SignUpDto;
import com.project.uber.Entity.LoginUser;
import com.project.uber.Repository.LoginUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginUserRepository userRepository;

    public String authenticateUser(LoginRequest request) {
        // 1. Fetch user from DB
        Optional<LoginUser> userOptional = userRepository
                .findByEmailAndIsActiveTrueAndIsDeletedFalse(request.getEmail());

        // 2. Check if user exists
        if (userOptional.isEmpty()) {
            return "Invalid email or password";
        }

        LoginUser user = userOptional.get();

        // 3. Check password (Note: In production, use BCrypt password encoder here!)
        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid email or passwordD";
        }

        // 4. Success
        return "Login successful. Welcome " + user.getFirstName() + "!";
    }
    public String SignUp(SignUpDto signUpDto) {

        return "Sign-up successful!";
    }
}