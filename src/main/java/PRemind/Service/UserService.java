package PRemind.Service;


import PRemind.Entity.User;
import PRemind.Repository.UserRepository;
import PRemind.Utils.TokenEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenEncryptor tokenEncryptor;

    public void signUp(User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList("ADMIN"));
        if (user.getGitToken() != null) {
            user.setGitToken(tokenEncryptor.encrypt(user.getGitToken()));

            userRepository.save(user);  // This will throw exception on duplicate
            System.out.println(tokenEncryptor.decrypt(user.getGitToken()));
        } else {
            log.warn("Git token is null for user: " + user.getUsername());
        }
    }
}
