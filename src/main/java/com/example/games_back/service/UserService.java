package com.example.games_back.service;

import com.example.games_back.model.Role;
import com.example.games_back.model.User;
import com.example.games_back.repository.RoleRepository;
import com.example.games_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByRoleName(String roleName) {
        return userRepository.findByRole_Name(roleName);
    }
    public User register(User user) {
        if (user.getRole() == null) {
            Role defaultRole = roleRepository.findByName("User")
                    .orElseThrow(() -> new RuntimeException("Роль 'User' не найдена"));
            user.setRole(defaultRole);
        }
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
