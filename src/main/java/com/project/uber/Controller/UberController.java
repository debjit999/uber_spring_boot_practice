package com.project.uber.Controller;

import com.project.uber.Entity.User_request;
import com.project.uber.Service.uberStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/maintain")
public class UberController {
@Autowired
uberStatusService uberStatusService_obj;
    @GetMapping("Uber99")
    public String getUber() {
        return "Hello Uber";
    }

    @GetMapping("Uber98")
    @ResponseStatus(HttpStatus.CREATED)
    public String getUber2(@RequestParam String s)
    {
        return uberStatusService_obj.getUberStatus(s);
    }

    @GetMapping("Uber97/{s}")
    @ResponseStatus(HttpStatus.CREATED)
    public String getUber3(@PathVariable String s)
    {
        return "Hello Uber + " + s;
    }


    @GetMapping("Uber96")
    public String getUber4(@RequestBody User_request user_request)
    {
        return "Hello Uber + " + user_request.getUser_message();
    }

}

