package org.petya8bachey.controller;

import org.petya8bachey.domain.*;
import org.petya8bachey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }
    public MyUser findUserById(Integer userId) {
        Optional<MyUser> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new MyUser());
    }

    public List<MyUser> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(MyUser user) {
        MyUser userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null)
            return false;
        user.roles = Collections.singleton(roleRepository.findByName("ROLE_USER"));
        user.password = (passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
