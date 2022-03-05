package io.github.sandeeplakka.transactionalsupport.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BookingService {

    @Qualifier()
    private final JdbcTemplate jdbcTemplate;

    public BookingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void book(String... persons){
        for(String person : persons){
            log.info("Booking "+person+" in a seat.");
            jdbcTemplate.update("INSERT INTO BOOKINGS(FIRST_NAME) VALUES (?)",person);
        }
    }
    public List<String> findAllBookings(){
        return jdbcTemplate.query("SELECT FIRST_NAME FROM BOOKINGS",
                (rs, rowNum) -> rs.getString("FIRST_NAME"));
    }
}
