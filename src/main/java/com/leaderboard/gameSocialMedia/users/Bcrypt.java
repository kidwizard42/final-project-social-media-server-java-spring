package com.leaderboard.gameSocialMedia.users;

import org.springframework.security.crypto.bcrypt.BCrypt;
public class Bcrypt {
    // private String plain_password;
    private String pw_hash;

    // constructor runs when new instance is made.
    // public Bcrypt(String plain_password){
    // this.plain_password = plain_password;
    // this.pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());

    // }

    public String saltPassword(String password){
        return this.pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        // System.out.println(this.pw_hash);
    }

    public Boolean checkPassword(String password, String hashedPw){

        return BCrypt.checkpw(password, hashedPw);
    }
}
