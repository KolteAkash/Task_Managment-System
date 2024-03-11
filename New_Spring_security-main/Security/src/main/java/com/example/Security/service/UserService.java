package com.example.Security.service;

import com.example.Security.model.Role;
import com.example.Security.model.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String username, String rolename);


}
