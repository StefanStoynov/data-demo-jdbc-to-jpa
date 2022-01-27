package com.ss.datademojdbctojpa.jdbc;

import com.ss.datademojdbctojpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    };

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?"
                , new Object[]{id}
                , new BeanPropertyRowMapper<>(Person.class));
    };

    public Person findByIdAndName(int id, String name) {
        return jdbcTemplate.queryForObject("select * from person where id = ? and name = ?"
                , new Object[]{id, name}
                , new BeanPropertyRowMapper<>(Person.class));
    };


}
