package io.pivotal;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "book", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

    List<Book> findByTitle(@Param("title") String title);

    List<Book> findByPublisher(@Param("publisher") String publisher);

}
