package com.example.springEmpresaXYZ.controllers.Site;

import com.example.springEmpresaXYZ.controllers.ProductController;
import com.example.springEmpresaXYZ.models.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaginaHomeController {

    private final ProductController productController;

    public PaginaHomeController(ProductController productController) {
        this.productController = productController;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<ProductModel> products = productController.getAllProducts().getBody();
        model.addAttribute("titulo", "Home");
        model.addAttribute("products", products);
        model.addAttribute("mensagem", "Olá Mundo");
        return "index";
    }
}
