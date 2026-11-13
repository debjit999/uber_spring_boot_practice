package com.project.uber.Controller;


import com.project.uber.Dto.LoginRequest;
import com.project.uber.Dto.UserDetailsDto;
import com.project.uber.Service.LoginService;
import com.project.uber.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    // Inject the Service instead of the Repository
    private final UserService userService;


    @PostMapping("/registerInfo")
    public ResponseEntity<Map<String, Object>> registerUserDetails(
            @RequestBody UserDetailsDto userDetailsDto) {

        String result = userService.registerUser(userDetailsDto);

        Map<String, Object> response = new HashMap<>();

        if (result.equals("User registered successfully!")) {

            response.put("success", true);
            response.put("message", result);
            response.put("status", HttpStatus.CREATED.value());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }

        if (result.startsWith("No login_user")) {

            response.put("success", false);
            response.put("message", result);
            response.put("status", HttpStatus.NOT_FOUND.value());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        if (result.startsWith("UserDetails already exists")) {

            response.put("success", false);
            response.put("message", result);
            response.put("status", HttpStatus.CONFLICT.value());

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(response);
        }

        response.put("success", false);
        response.put("message", "Something went wrong");
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
