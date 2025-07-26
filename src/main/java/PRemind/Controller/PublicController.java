package PRemind.Controller;


import PRemind.Entity.User;
import PRemind.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class PublicController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user){
        try {
            userService.signUp(user);
            return new ResponseEntity<>("User "+user.getUsername()+" created Successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> signIn(@RequestBody User user){
        try {
            userService.signUp(user);
            return new ResponseEntity<>("User "+user.getUsername()+" created Successfully", HttpStatus.CREATED);
            //JWT Implementation
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
