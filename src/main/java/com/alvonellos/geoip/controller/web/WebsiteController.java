package com.alvonellos.geoip.controller.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class WebsiteController {
    private final DataSource dataSource;

    @GetMapping("/robots.txt")
    public String robotsTxt(Model model) {
        model.addAttribute("sitemapUrl", "https://geoip.home.alvonellos.com/sitemap.xml");
        return "text/robots"; // Return the text template name
    }

    @GetMapping("/favicon.ico")
    public String favicon() {
        log.entering(this.getClass().getName(), "favicon.ico");
        return "forward:/img/favicon.ico";
    }

    @GetMapping({"/", "index.html"})
    public String index(HttpServletRequest request, Model model) {
        log.info("Getting index");
        return "index";
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        log.severe("Getting error");
        return "error";
    }
}