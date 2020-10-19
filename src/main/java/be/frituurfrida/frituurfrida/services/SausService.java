package be.frituurfrida.frituurfrida.services;

import be.frituurfrida.frituurfrida.domain.Saus;

import java.util.List;
import java.util.Optional;

public interface SausService {
    List<Saus> findAll();
    List<Saus> findByNaamBegintMet(char letter);
    Optional<Saus> findById(int id);
}


