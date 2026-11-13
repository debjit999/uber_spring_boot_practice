package com.project.uber.Controller;

import com.project.uber.Dto.LoginRequest;
import com.project.uber.Dto.SignUpDto;
import com.project.uber.Service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Login")
public class LoginController {

    // Inject the Service instead of the Repository
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {  //88

        // Call the service to do the authentication
        String resultMessage = loginService.authenticateUser(request);

        // Check if the service returned a success message or an error
        if (resultMessage.startsWith("Invalid")) {
            return ResponseEntity.status(401).body(resultMessage);
        }

        return ResponseEntity.ok(resultMessage);
    }



    @PostMapping("/SignUP")
    public ResponseEntity<String> SignUp(@RequestBody SignUpDto SignUpDto) {

        // Call the service to do the authentication
        String resultMessage = loginService.SignUp(SignUpDto);

        // Check if the service returned a success message or an error
        if (resultMessage.startsWith("InvalidD")) {
            return ResponseEntity.status(401).body(resultMessage);
        }

        return ResponseEntity.ok(resultMessage);
    }



}