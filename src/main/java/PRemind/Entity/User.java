package PRemind.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGIT_TOKEN() {
        return GIT_TOKEN;
    }

    public void setGIT_TOKEN(String GIT_TOKEN) {
        this.GIT_TOKEN = GIT_TOKEN;
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> roles) {
        Roles = roles;
    }

    public List<PullRequest> getListOfPRs() {
        return listOfPRs;
    }

    public void setListOfPRs(List<PullRequest> listOfPRs) {
        this.listOfPRs = listOfPRs;
    }

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String GIT_TOKEN;

    private List<String> Roles;
    private List<PullRequest> listOfPRs;
}
