package org.petya8bachey.controller;

import org.petya8bachey.domain.MyData;
import org.petya8bachey.domain.MyUser;
import org.petya8bachey.repository.DataRepository;
import org.petya8bachey.repository.RoleRepository;
import org.petya8bachey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public String postHelp(@RequestParam("1") String string, @RequestParam("2") String string1) {
        return string + string1;
    }

    @GetMapping("/registration")
    public MyPacket<String> registration() {
        return new MyPacket<>(null, "Use POST request");
    }

    @PostMapping("/registration")
    public MyPacket<String> addUser(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        if (!userService.saveUser(new MyUser(username, password))) {
            return new MyPacket<>(null, "Username is busy");
        }
        return new MyPacket<>("Registration is done");
    }

    @PostMapping("/data/add")
    @Secured("ROLE_USER")
    public MyPacket<String> addData(@RequestParam("data") String data) {
        dataRepository.save(new MyData(data));
        return new MyPacket<>("Data add");
    }
    @PostMapping("/data/delete")
    @Secured("ROLE_USER")
    public MyPacket<String> deleteData(@RequestParam("id") Integer id) {
        dataRepository.deleteById(id);
        return new MyPacket<>("Data delete");
    }

    @GetMapping("/data/get")
    @Secured("ROLE_USER")
    public MyPacket<List<MyData>> getData(@RequestParam("id") Integer id) {
        if(id == 0) {
            return new MyPacket<List<MyData>>(dataRepository.findAll());
        }
        return new MyPacket<>(dataRepository.findAllById(Collections.singleton(id)));
    }

    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")
    public MyPacket<List<MyUser>> userList() {
        return new MyPacket<>(userService.allUsers());
    }

    @PostMapping("/admin/delete")
    @Secured("ROLE_ADMIN")
    public MyPacket<String> deleteUser(@RequestParam("id") Integer userId) {
        userService.deleteUser(userId);
        return new MyPacket<>("User delete");
    }

    @GetMapping("/admin/get")
    @Secured("ROLE_ADMIN")
    public MyPacket<MyUser> getUser(@RequestParam("id") Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            return new MyPacket<>(userRepository.findById(userId).orElse(new MyUser()));
        }
        return new MyPacket<>(null, "Id isn't found");
    }
}
