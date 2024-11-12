package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatApplicationController {

    String visitorsName;
    Long userId = 0L;

    @Autowired
    private MessageService messageService;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

//****************************************************************************





        @GetMapping("/submit")
        public String submitForm(@RequestParam("name") String name, @RequestParam("email") String email) {
            // Process the form data (e.g., save to database)
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

            // Redirect to a success page or return a view
            return "test";
        }

    //      NEW

    @GetMapping("/channels")
    public String getChannel(@RequestParam("channel") String channel,@RequestParam("name") String name, ModelMap model) {
        //messageService.getAllMessages(channel);

        System.out.println("Name: " + name);
        System.out.println("channel: " + channel);

        model.addAttribute("name", name);
        model.addAttribute("channel", channel);
        return "channels";
    }


//****************************************************************************
//    @PostMapping("/channels/{channel}/{name}")
//    public String saveUserToDB(@RequestBody User user, @PathVariable String channel, @PathVariable String name) {
//
//        userService.createUser(user, channel);
//        //String name = user.getName();
////        visitorsName = user.getName();
////        userId++;
////        user.setId(userId);
////        user.setChannel(channel);
//        System.out.println("name and chennel:" + name + channel);
//        return "redirect:/channels/{channel}/{name}";
//    }

    //      OLD
//    @GetMapping("/channels/{channel}/{name}")
//    public String getChannel(ModelMap model, @PathVariable String channel, @PathVariable String name) {
//        //messageService.getAllMessages(channel);
//        model.addAttribute("name", name);
//        model.addAttribute("channel", channel);
//        return "channels";
//    }



    @PostMapping("/postDataToServer/{channel}")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody Message message, ModelMap model , @PathVariable String channel) {



        messageService.saveMessage(message, channel);
        //return ResponseEntity.ok().body(messageService.getAllMessages(channel));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/returnAllMessages/{channel}")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model, @PathVariable String channel) {
        List<Message> listOfMessages = messageService.getAllMessages(channel);
        return ResponseEntity.ok().body(listOfMessages);
    }
}
