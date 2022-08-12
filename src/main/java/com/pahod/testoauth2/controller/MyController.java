package com.pahod.testoauth2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/")
public class MyController {


    @GetMapping("/home")
    @PermitAll
    public String homePage() {
        return "access for all";
    }

    @GetMapping("/user_page")
    @RolesAllowed({"USER", "ADMIN"})
    public String userPage(Model model) {
        return "page allowed for USER and ADMIN.";
    }

    @GetMapping("/admin_page")
    @RolesAllowed("ADMIN")
    public String adminPage() {
        return "page allowed ADMIN only.";
    }
}
