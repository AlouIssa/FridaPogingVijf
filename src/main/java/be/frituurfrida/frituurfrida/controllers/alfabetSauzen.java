package be.frituurfrida.frituurfrida.controllers;

import be.frituurfrida.frituurfrida.domain.Saus;
import be.frituurfrida.frituurfrida.repositories.SausRepository;
import be.frituurfrida.frituurfrida.services.SausService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("alfabetSauzen")
public class alfabetSauzen {
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private SausService sausService;
    public alfabetSauzen(SausService sausService){
        this.sausService = sausService;
    }
    @GetMapping
    public ModelAndView alfabet(){
        return new ModelAndView("alfabetSauzen","alfabet",alfabet);
    }

    private List<Saus> gevonden(@PathVariable Character letter){
        return sausService.findByNaamBegintMet(letter).stream().collect(Collectors.toList());
    }

    @GetMapping("{letter}")
    public ModelAndView saus(@PathVariable Character letter){
        return new ModelAndView("alfabetSauzen","gevonden",gevonden(letter)).addObject("alfabet",alfabet);
    }
}
