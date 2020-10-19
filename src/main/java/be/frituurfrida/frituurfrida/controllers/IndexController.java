package be.frituurfrida.frituurfrida.controllers;

import be.frituurfrida.frituurfrida.domain.Adres;
import be.frituurfrida.frituurfrida.domain.Gemeente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView index(@CookieValue(name = "reedsBezocht",required = false) String reedsBezocht ,HttpServletResponse response){
        var cookie = new Cookie("reedsBezocht","ja");
        cookie.setMaxAge(3);
        cookie.setPath("/");
        response.addCookie(cookie);
        var openGesloten = LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY) ? "gesloten":"open";
        var model = new ModelAndView("index","openGesloten",openGesloten);
        model.addObject("adres",new Adres("Steenstraat","21",new Gemeente("Hove",2500)));
        model.addObject("reedsBezocht",reedsBezocht != null ? true : false);
        return model;
    }
}
//Kan ook op volgende manier -->  LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY


