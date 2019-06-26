package com.nhi.bookstore;

import com.nhi.bookstore.model.Book;
import com.nhi.bookstore.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private BookRepository bookRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		bookRepository.save(new Book());
	}

}
