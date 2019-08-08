package com.mahjoubhamza.springboot.blog.controller;

import com.mahjoubhamza.springboot.blog.model.User;
import com.mahjoubhamza.springboot.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * mim
 * 08/08/2019
 */

@Controller
public class RegistrationController {
    private final UserService userService;


    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "/registration";
    }


    @PostMapping("/registration")
    public String createUser(@Valid User user, Model model, BindingResult bindingResult){

        //isPresent() ==  !=null
     if(userService.findByEmail(user.getEmail()).isPresent()){
         bindingResult
                 .rejectValue("email", "error.user",
                         "There is already a user registered with the email provided");

     }
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        if (!bindingResult.hasErrors()) {
            userService.save(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }
        return "/registration";
    }
}
