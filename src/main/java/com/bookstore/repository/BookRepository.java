//the repository basically used to interact with DB, TO SAVE FETCH UPDATE AND DELETE BOOKS.we'll use JPA repository from spring Data JPA
package com.bookstore.repository;

import com.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
//we have created interface not the class, because it represents contract which provides list of methods like save(), finadAll, deleteById() etc., 
//we need not implement them manually, springboot implements automatically. if you take as a class, you need to SQL logic for 
//every method manually. Springboot saves from that effort using line 6.