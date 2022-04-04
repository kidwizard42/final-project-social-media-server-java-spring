package com.leaderboard.gameSocialMedia.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name  = "Users.findByUsername",
        query =  "SELECT * FROM users WHERE username = ?",
        resultClass = Users.class
)
@NamedNativeQuery(
        name  = "Users.grabPassword",
        query =  "SELECT password FROM users WHERE username = ? LIMIT 1",
        resultClass = Users.class
)
public abstract class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String username;
    private String aboutMe;

    protected Users() {
    }

//    public Users(Integer id, String username, String aboutMe, String password) {
//        this.id = id;
//        this.username = username;
//        this.aboutMe = aboutMe;
//        setPassword(password);
//    }

    @JsonIgnore
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
