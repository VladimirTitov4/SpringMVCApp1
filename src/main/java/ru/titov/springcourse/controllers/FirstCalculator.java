package ru.titov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstCalculator {

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
                                 Model model) {

        String result = "";

        switch (action) {
            case "sub":
                result += String.valueOf(a - b);
                break;
            case "add":
                result += String.valueOf(a + b);
                break;
            case "div":
                if (b != 0) {
                    result += String.valueOf(a / b);
                } else {
                    model.addAttribute("result", "division by zero");
                }
                break;
            case "mul":
                result += String.valueOf(a * b);
                break;
        }

        model.addAttribute("result", "result is " + result);

        return "first/calculator";
    }
}
