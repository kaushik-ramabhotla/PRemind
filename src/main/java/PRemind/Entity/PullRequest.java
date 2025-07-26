package PRemind.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class PullRequest {

    public Long id;
    private String author;
    private List<User> reviewers;
}
