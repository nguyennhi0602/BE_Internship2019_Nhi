package com.nhi.bookstore.configurations;

import com.nhi.bookstore.exceptions.NotFoundException;
import com.nhi.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private BookRepository bookRepository;

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        if(!bookRepository.existsById(id)){
            throw new NotFoundException(String.format("Book id %d not found", id));
        }
        bookRepository.deleteById(id);
    }
}
