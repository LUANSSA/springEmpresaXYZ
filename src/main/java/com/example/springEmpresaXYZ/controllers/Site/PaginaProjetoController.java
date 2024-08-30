package com.example.springEmpresaXYZ.controllers.Site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaProjetoController {

    @GetMapping("/projetos")
    public String projetos(Model model) {

        model.addAttribute("titulo", "Projetos");
        return "projetos";
    }
}
