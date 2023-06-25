package org.petya8bachey.controller;

import org.petya8bachey.domain.MyData;
import org.petya8bachey.domain.MyRole;
import org.petya8bachey.domain.MyUser;
import org.petya8bachey.repository.DataRepository;
import org.petya8bachey.repository.RoleRepository;
import org.petya8bachey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @Autowired
    DataRepository dataRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/reg")
    public String helloWorld() {
        return "hello";
    }

    @PostMapping("/add/data")
    public void addData(@RequestBody MyData data) {
        dataRepository.save(data);
    }

    @PostMapping("/add/user")
    public void addUser(@RequestBody MyUser user) {
        userRepository.save(user);
    }

    @PostMapping("/add/role")
    public void addRole(@RequestBody MyRole role) {
        roleRepository.save(role);
    }

    @GetMapping("/get/data")
    @ResponseBody
    public MyPacket<MyData> getData(@RequestBody Integer ID) {
        MyPacket<MyData> data = new MyPacket<MyData>();
        if (dataRepository.existsById(ID)) {
            data.data = dataRepository.findById(ID).orElse(new MyData());
        } else {
            data.description = "ID not find";
        }
        return data;
    }

    public void addData1( MyData data) {
        dataRepository.save(data);
    }
}
