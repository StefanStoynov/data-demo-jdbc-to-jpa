package com.ss.datademojdbctojpa;

import com.ss.datademojdbctojpa.entity.Person;
import com.ss.datademojdbctojpa.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DataDemoJdbcToJpaApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(DataDemoJdbcToJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}",
                dao.findAll()
        );
        logger.info("User with Id 10001 -> {}",
                dao.findById(10001)
        );
        logger.info("User with Id 10002 and Name Petar -> {}",
                dao.findByIdAndName(10002, "Petar")
        );
        logger.info("Delete User with Id 10003 -> Number of rows deleted {}",
                dao.deleteById(10003)
        );
        logger.info("Inserting User with Id 10004 -> Number of rows inserted {}",
                dao.insert(new Person(10004, "Stamat", "Vratsa", new Date()))
        );
        logger.info("updating User with Id 10002 -> Number of rows updated {}",
                dao.update(new Person(10002, "Petar", "Vratsa", new Date()))
        );
    }
}
