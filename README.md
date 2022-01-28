# data-demo-jdbc-to-jpa
this project is simple DB project 

# H2
To be able to connect to H2 in memory DB:
    - populate application.properties with
        spring.datasource.url=jdbc:h2:mem:testdb
        spring.data.jpa.repositories.bootstrap-mode=default 
        spring.h2.console.enabled=true
    - url: localhost:8080/h2-console
    - in case of H2 creating tables problems visit:
https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/jpa-and-hibernate.md

Create a new table in H2 DB:
    - create data.sql file under /resources
    - populate it with create table query:
        create table person
        (
        id integer not null,
        name varchar(255) not null,
        location varchar(255),
        birth_date timestamp,
        primary key (id)
        );

Populate H2 table
    - just write a simple insert into query

If Row mapper doesn't match with the columns of the DAO object, we can write a custom one like this one:

class PersonRowMapper implements RowMapper<Person>{
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }
and use it:
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    };