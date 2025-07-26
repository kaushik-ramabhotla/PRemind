package PRemind.Controller;


import PRemind.Service.GitService;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private GitService gitService;

    @PostMapping("/getAllMyPullRequests")
    @Description("Gets a list of pr's created by a user")
    public ResponseEntity<Object> getAllPRsForUser(@RequestBody String id){
        //step-1 - Check whether the user exists in the current organization
        return gitService.checkUser(id);
    }
}
