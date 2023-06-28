package org.petya8bachey.controller;

import org.petya8bachey.domain.MyData;
import org.petya8bachey.domain.MyRole;
import org.petya8bachey.domain.MyUser;
import org.petya8bachey.repository.DataRepository;
import org.petya8bachey.repository.RoleRepository;
import org.petya8bachey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    DataRepository dataRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/help")
    public String getHelp() {
        return "hello";
    }
    @PostMapping("/help")
    public String postHelp(@RequestParam(name = "1") String string, @RequestParam(name = "2") String string1) {
        return string + string1;
    }

    @GetMapping("/registration")
    public MyPacket<String> registration() {
        return new MyPacket(null, "Use POST request");
    }

    @PostMapping("/registration")
    public MyPacket<String> addUser(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password) {
        if (!userService.saveUser(new MyUser(username, password))){
            return new MyPacket(null, "Username is busy");
        }
        return new MyPacket("Registration is done");
    }
    @GetMapping("/admin")
    public MyPacket<List> userList() {
        return new MyPacket(userService.allUsers());
    }
    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Integer userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }
}
