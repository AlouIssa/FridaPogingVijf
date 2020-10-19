package be.frituurfrida.frituurfrida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
@RequestMapping("taal")
public class TaalController {
    private static final String osTaal = "nl";
    @GetMapping
    public ModelAndView taal(@RequestHeader("accept-language") String acceptLanguage){
        var modelAndView = new ModelAndView("taal");
        modelAndView.addObject("nl", acceptLanguage.contains(osTaal));
        return modelAndView;
    }
}
