package com.leaderboard.gameSocialMedia;

import com.leaderboard.gameSocialMedia.games.guessingGame.GuessingGameSBRepository;
import com.leaderboard.gameSocialMedia.games.guessingGame.GuessingGameScoreBoard;
import com.leaderboard.gameSocialMedia.posts.Post;
import com.leaderboard.gameSocialMedia.posts.PostRepository;
import com.leaderboard.gameSocialMedia.users.Bcrypt;
import com.leaderboard.gameSocialMedia.users.UserRepository;
import com.leaderboard.gameSocialMedia.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class GameSocialMediaApplication {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GuessingGameSBRepository guessingGameSBRepository;


    public static void main(String[] args) {
        SpringApplication.run(GameSocialMediaApplication.class, args);
        // Create an encoder with strength 16
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        // String result = encoder.encode("myPassword");
        // assertTrue(encoder.matches("myPassword", result));

        // test.checkPassword("123");
    }

    // routes for post repository
    @GetMapping("/posts")
    public Iterable<Post> index() {
        return postRepository.findAll();
    }

    @PostMapping("/posts")
    public Iterable<Post> create (@RequestBody Post postData) {
        postRepository.save(postData);
        return postRepository.findAll();
    }

    @DeleteMapping("/posts/{id}")
    public Iterable<Post> delete(@PathVariable int id) {
        postRepository.deleteById(id);
        return postRepository.findAll();
    }

    @PutMapping("/posts/{id}")
    public Iterable<Post> update(@PathVariable int id, @RequestBody Post postData) {
        postData.setId(id);
        postRepository.save(postData);
        return postRepository.findAll();
    }

    // ROUTES FOR THE GUESSING GAME
    @GetMapping("/guessingGame")
    public Iterable<GuessingGameScoreBoard> indexGG() {
        return guessingGameSBRepository.findAll();
    }

    // @CrossOrigin(origins = "*")
    @PostMapping("/guessingGame")
    public Iterable<GuessingGameScoreBoard> createGG(@RequestBody GuessingGameScoreBoard postData) {
        guessingGameSBRepository.save(postData);
        return guessingGameSBRepository.findAll();
    }

    @GetMapping("/guessingGameTop")
    public Iterable<GuessingGameScoreBoard> indexGGTop() {
        return guessingGameSBRepository.findTop();
    }

    //    JUST TO CLEAR SOME DATA WHEN I NEED TO
    @DeleteMapping("guessingGameTop/{id}")
    public Iterable<GuessingGameScoreBoard> deleteScore(@PathVariable int id) {
        guessingGameSBRepository.deleteById(id);
        return guessingGameSBRepository.findAll();

    }


    // ROUTES FOR USER REPOSITORY
    // FOR LOGGING IN. GET RID OF THE GET.

    // creates users/salts the password and stores it in the database
    @PostMapping("/users")
    public Iterable<Users> createUser (@RequestBody Users UserData) {
        // Bcrypt bcrypt = new Bcrypt();
        // System.out.println(bcrypt.saltPassword(UserData.getPassword()));
        // UserData.setPassword(bcrypt.saltPassword(UserData.getPassword()));
        userRepository.save(UserData);
        return userRepository.findAll();
    }

    // THIS ONE IS BROKEN. CANNOT CONVERT REQUEST TO STRING TO COMPARE.
    @PostMapping("/users/login/{username}/{password}")
    public Boolean getUser (@PathVariable String username, @PathVariable String passwordAttempt ) {
        Bcrypt bcrypt = new Bcrypt();

        // Iterable<Users>

        // reqParam.setUsername(reqParam.username);
        // reqParam.setPassword(reqParam.password);
        // String stringUsername = reqParam.getUsername();
        // String stringPassword = reqParam.getPassword();

        // System.out.println(bcrypt.checkPassword(,userRepository.grabPassword(reqParam.getPassword())));
        System.out.println(username);
        System.out.println(userRepository.grabPassword(username));

        // return bcrypt.checkPassword("organ","should work organs");

        return true;

        //  if (bcrypt.checkPassword(reqParam.password,userRepository.grabPassword(reqParam.username))){
        //     return userRepository.findByUsername(reqParam.username);
        // }else{
        //     System.out.println("something is wrong");
        // }
    }

    @DeleteMapping("/users/{id}")
    public Iterable<Users> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

    @PutMapping("/users/{id}")
    public Iterable<Users> updateUser(@PathVariable int id, @RequestBody Users postData) {
        postData.setId(id);
        userRepository.save(postData);
        return userRepository.findAll();
    }
}
