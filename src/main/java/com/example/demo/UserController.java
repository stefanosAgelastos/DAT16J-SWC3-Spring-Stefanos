package com.example.demo;

import com.sun.xml.internal.ws.server.ServerRtException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by coag on 24-10-2017.
 */
@Controller
public class UserController {
    private static AtomicLong counter = new AtomicLong();


    @PostMapping("/user/saveandget")
    public ModelAndView saveAndShow(
            @RequestParam(name = "name", defaultValue = "NO_NAME")
                    String name,
            @RequestParam(name = "email", defaultValue = "NO_EMAIL")
                    String email) {

        User u = new User(counter.incrementAndGet(), name, email);

        User.getUserList().add(u);

        ModelAndView mv = new ModelAndView("user");
        mv.getModel().put("usersList", User.getUserList());
        mv.getModel().put("user", u);
        return mv;
    }
}
