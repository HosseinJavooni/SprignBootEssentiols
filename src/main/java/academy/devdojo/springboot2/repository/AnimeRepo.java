package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AnimeRepo {
    public List<Anime> animeList(){
        return Arrays.asList(new Anime(1,"Hossein"), new Anime(2, "Mahdi"));
    }
}
