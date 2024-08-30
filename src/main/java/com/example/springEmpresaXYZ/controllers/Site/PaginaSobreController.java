package com.example.springEmpresaXYZ.controllers.Site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaSobreController {

    @GetMapping("/sobre")
    public String sobre(Model model) {

        model.addAttribute("titulo", "Sobre");
        return "sobre";
    }
}
