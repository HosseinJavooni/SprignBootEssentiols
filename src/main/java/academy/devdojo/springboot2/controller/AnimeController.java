package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepo;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/animes")
@Slf4j
public class AnimeController {

    private DateUtil dateUtil;
    private AnimeRepo animeRepo;

    @Autowired
    public AnimeController(DateUtil dateUtil, AnimeRepo animeRepo){
        this.dateUtil = dateUtil;
        this.animeRepo = animeRepo;
    }

    @RequestMapping(method = RequestMethod.GET , path = "/list")
    public ResponseEntity<List<Anime>> listOfAnime(){
        log.info("This is log & logTime is: {}",dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        return ResponseEntity.badRequest().body(animeRepo.animeList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> returnAnime(@PathVariable int id){
        return
                ResponseEntity.ok(animeRepo.animeList()
                        .stream()
                        .filter(anime -> anime.getId() == id)
                        .findFirst()
                        //.orElseThrow(NullPointerException::new));
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Thi is Hossein Exeption")));
    }

}
