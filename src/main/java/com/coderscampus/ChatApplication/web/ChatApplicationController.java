package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatApplicationController {



    String yourName;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @PostMapping("/channels")
    private String channels(@RequestBody User user, ModelMap model) {
        System.out.println("Name Bubu: " + user.getName());
        yourName = user.getName();
        //model.put("name", "vardas");
        return "redirect:/channels";
    }

//    @PostMapping("/channels")
//    private String channels(@RequestBody String name, ModelMap model) {
//        System.out.println("Name Bubu: " + name);
//        //yourName = name;
//
//        User user = new User();
//        user.setName(name);
//        model.put("user", user);
//
//        return "channels";
//    }


    @GetMapping("/channels")
    private String getChannels(ModelMap model) {
        System.out.println("yourName == " + yourName);

        User user2 = new User();
        user2.setName(yourName);
        model.put("user", user2);
        return "channels";
    }
}
