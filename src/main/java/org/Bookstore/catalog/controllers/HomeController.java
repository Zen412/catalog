package org.Bookstore.catalog.controllers;

import org.Bookstore.catalog.config.PolarProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    PolarProperties polarProperties;

    public HomeController(PolarProperties polarProperties){
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String home() {
        return polarProperties.getGreeting();
    }
}
