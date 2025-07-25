package PRemind.Entity;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data

public class User {

    private String id;

    private List<PullRequest> listOfPRs;
}
