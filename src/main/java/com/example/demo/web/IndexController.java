package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.dto.SessionUser;
import com.example.demo.service.PtextService;
import com.example.demo.web.dto.PtextResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PtextService ptextService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("ptexts", ptextService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        
        System.out.println("test");
        
        return "index";
    }

    @GetMapping("/ptexts/save")
    public String ptextsSave() {
        return "ptextssave";
    }

    @GetMapping("/ptexts/update/{id}")
    public String ptextsUpdate(@PathVariable Long id, Model model) {
        PtextResponseDto dto = ptextService.findById(id);
        model.addAttribute("ptext", dto);

        return "ptextsupdate";
    }
}