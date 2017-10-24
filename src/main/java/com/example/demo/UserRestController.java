package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by coag on 24-10-2017.
 */
@RestController
public class UserRestController {
    private static AtomicLong counter = new AtomicLong();

    @GetMapping("/user")
    public User showUser() {
        User u = new User(counter.incrementAndGet(), "aliceGET", "alice@bob.com");
        return u;
    }

    @PostMapping("/user/save")
    public List<User> showUserPost(
            @RequestParam(name = "name", defaultValue = "NO_NAME")
                    String name,
            @RequestParam(name = "email", defaultValue = "NO_EMAIL")
                    String email) {
        User u = new User(counter.incrementAndGet(), name, email);
        User.getUserList().add(u);
        return User.getUserList();
    }

}
