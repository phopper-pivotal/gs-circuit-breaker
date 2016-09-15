package io.pivotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookstoreApplication {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/recommendedTitle")
    public String recommendedTitle() {
        Double index = new Double(Math.round(Math.random() * 10));
        System.out.println("index = " + index);

        return bookRepository.findOne(index.longValue()).getTitle();
    }

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }
}