package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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

    @PostMapping("/user/edit")
    public static String showForEdit(
            @RequestParam(name = "id", required = true)
                    long id,
            Model model
    ){
        System.out.println("showForEdit controller method invoked");
        User u = User.findUserById(id);
        model.addAttribute("user",u);
        return "edit";
    }

    @PostMapping("/user/saveEdit")
    public static ModelAndView editSaveAndShow(
            @RequestParam(name = "name", defaultValue = "NO_NAME")
                    String name,
            @RequestParam(name = "email", defaultValue = "NO_EMAIL")
                    String email,
            @RequestParam(name = "id", required = true)
                    Long id
    ) {
        User u = User.findUserById(id);
        u.setName(name);
        u.setEmail(email);
        ModelAndView mv = new ModelAndView("user");
        mv.getModel().put("usersList", User.getUserList());
        mv.getModel().put("user", u);
        return mv;


    }

    @PostMapping("/user/delete")
    public static ModelAndView deleteandshow(
            @RequestParam(name = "id", required = true)
                    long id,
            Model model) {
            User u = User.findUserById(id);
            //User.getUserList().remove(u);
            List<User> list = User.getUserList();
            list.remove(u);
            ModelAndView mv = new ModelAndView("user");
            mv.getModel().put("usersList", User.getUserList());
            mv.getModel().put("user", u);
            return mv;
    }

}
