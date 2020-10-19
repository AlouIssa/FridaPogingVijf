package be.frituurfrida.frituurfrida;

import be.frituurfrida.frituurfrida.domain.Saus;
import be.frituurfrida.frituurfrida.exceptions.SausRepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    private static final Path PAD = Path.of("/data/sauzen.properties");
    public static void main(String[] args) {
            var  sauzen = new ArrayList<Saus>();
            try {
                Files.lines(PAD).filter(regel -> ! regel.isEmpty()).forEach(a->System.out.println(a));
            }catch (IOException ex){
                throw new SausRepositoryException("Fout bij lezen " + PAD);
            }
    }
}
