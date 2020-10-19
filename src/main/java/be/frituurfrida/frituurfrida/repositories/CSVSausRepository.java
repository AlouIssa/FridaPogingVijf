package be.frituurfrida.frituurfrida.repositories;

import be.frituurfrida.frituurfrida.domain.Saus;
import be.frituurfrida.frituurfrida.exceptions.SausRepositoryException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CSVSausRepository implements SausRepository{
    private final Path pad;
    CSVSausRepository(@Value("${csvData}") Path pad){
        this.pad = pad;
    }
    @Override
    public List<Saus> findAll() {
        var  sauzen = new ArrayList<Saus>();
        try {
            return Files.lines(pad)
                    .filter(regel -> ! regel.isEmpty())
                    .map(regel -> maakSaus(regel))
                    .collect(Collectors.toList());
        }catch (IOException ex){
            throw new SausRepositoryException("Fout bij lezen " + pad);
        }
    }
    private Saus maakSaus(String regel) {
        var onderdelen = regel.split(",");
        if (onderdelen.length < 2) {
            throw new SausRepositoryException(
                    pad + ":" + regel + " bevat minder dan 2 onderdelen");
        }
        try {
            var ingredienten = Arrays.copyOfRange(onderdelen, 2, onderdelen.length);
            return new Saus(Integer.parseInt(onderdelen[0]),onderdelen[1],ingredienten);
        } catch (NumberFormatException ex) {
            throw new SausRepositoryException(pad + ":" + regel + " bevat verkeerde id");
        }
    }
}
