package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class AnimeRepo {
    public List<Anime> animeList() {
        try (InputStream inputStream = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return Arrays.asList(new Anime(1, "Hossein" + properties.getProperty("server.error.include-stacktrace")), new Anime(2, "Mahdi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
