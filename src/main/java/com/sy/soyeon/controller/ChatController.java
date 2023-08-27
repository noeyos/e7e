package com.sy.soyeon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class ChatController {

    @GetMapping("/chat")
    public String chatChat(HttpSession httpSession) {
        httpSession.setAttribute("myName", "soyeonlee");
        return "chat";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/commute")
    public String commute() {
        return "commute";
    }
}
