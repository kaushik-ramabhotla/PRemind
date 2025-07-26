package PRemind.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Getter
@Setter
public class User {

    private String username;
    private String password;
    private String GIT_TOKEN;
    private List<PullRequest> listOfPRs;
}
