package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class BookstoreApplication {
    private static List<String> readingList;

    @RequestMapping(value = "/recommended")
    public String readingList(){
        return readingList.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }
}