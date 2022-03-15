package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @RequestMapping(method = RequestMethod.GET , path = "/list")
    public List<Anime> listOfAnime(){
        List<Anime> listOfAnime = Arrays.asList(new Anime("Hossein"), new Anime("Mahdi"));
        return listOfAnime;
    }

}
