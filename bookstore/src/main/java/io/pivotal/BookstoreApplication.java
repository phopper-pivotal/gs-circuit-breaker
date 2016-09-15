package io.pivotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class BookstoreApplication {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/recommendedTitles")
    public String recommendedTitles() {
        return bookRepository.findByPublisher("OReilly").stream().map(Book::getTitle).collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }
}