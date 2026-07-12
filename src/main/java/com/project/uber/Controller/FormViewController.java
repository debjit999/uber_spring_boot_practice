package com.project.uber.Controller;

import com.project.uber.Entity.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormViewController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("student", new Student());

        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {

        if (result.hasErrors()) {
            return "index";
        }

        return "success";
    }

}