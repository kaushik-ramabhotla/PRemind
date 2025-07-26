package PRemind.Service;


import PRemind.Entity.User;
import PRemind.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private UserRepository userRepository;

    public void signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode only once
        user.setRoles(Collections.singletonList("ADMIN"));
        userRepository.save(user);
    }

}
