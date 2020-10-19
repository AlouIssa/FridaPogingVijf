package be.frituurfrida.frituurfrida.services;

import be.frituurfrida.frituurfrida.domain.Saus;
import be.frituurfrida.frituurfrida.exceptions.SausRepositoryException;
import be.frituurfrida.frituurfrida.repositories.SausRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DefaultSausService implements SausService{
    private final SausRepository[] sausRepositories;
    public DefaultSausService(SausRepository[] sausRepositories){
        this.sausRepositories = sausRepositories;
    }
    @Override
    public List<Saus> findAll() {
        for (var client:sausRepositories) {
            return client.findAll()   ;
        }
        throw new SausRepositoryException("Kan dollar koers nergens lezen");
    }

    @Override
    public List<Saus> findByNaamBegintMet(char letter) {
        for (var client:sausRepositories) {
            return  client.findAll().stream().filter(saus->saus.getNaam().charAt(0)==letter).collect(Collectors.toList());
        }
        throw new SausRepositoryException("Kan dollar koers nergens lezen");
    }

    @Override
    public Optional<Saus> findById(int id) {
        for (var client:sausRepositories) {
            return client.findAll().stream().filter(saus->saus.getId()==id).findFirst();
        }
        throw new SausRepositoryException("Kan dollar koers nergens lezen");
    }
}
