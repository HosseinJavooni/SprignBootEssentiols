package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/anime")
@Slf4j
public class AnimeController {

    private DateUtil dateUtil;

    @Autowired
    public AnimeController(DateUtil dateUtil){
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET , path = "/list")
    public List<Anime> listOfAnime(){
        log.info("This is log & logTime is: {}",dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        List<Anime> listOfAnime = Arrays.asList(new Anime("Hossein"), new Anime("Mahdi"));
        return listOfAnime;
    }

}
