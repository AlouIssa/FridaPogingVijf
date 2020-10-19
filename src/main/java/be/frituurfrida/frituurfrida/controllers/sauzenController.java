package be.frituurfrida.frituurfrida.controllers;

import be.frituurfrida.frituurfrida.domain.Saus;
import be.frituurfrida.frituurfrida.services.SausService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.stream.Stream;

@Controller
@RequestMapping("Sauzen")
public class sauzenController {
    private SausService sausService;
    public sauzenController(SausService sausService){
        this.sausService = sausService;
    }

    @GetMapping
    public ModelAndView sauzen(){
        return new ModelAndView("Sauzen","sauzenData",sausService.findAll());
    }

    @GetMapping("{id}")
    public ModelAndView saus(@PathVariable Integer id){
        var modelAndView = new ModelAndView("saus");                         // --> saus.html
        sausService.findById(id).ifPresent(saus -> modelAndView.addObject("sausinfo",saus));
        return modelAndView;
    }
}
