package io.pivotal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "book", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

    @RestResource(path="findByTitle", rel="findByTitle")
    List<Book> findByTitleIgnoreCase(@Param("title") String title);

    @RestResource(path="findByPublisher", rel="findByPublisher")
    List<Book> findByPublisherIgnoreCase(@Param("publisher") String publisher);

    @RestResource(path="titleStartsWith", rel="titleStartsWith")
    Page findByTitleStartsWithIgnoreCase(@Param("title") String title, Pageable pageable);

    @RestResource(path="publisherStartsWith", rel = "publisherStartsWith")
    Page findByPublisherStartsWithIgnoreCase(@Param("publisher") String publisher, Pageable pageable);

}
