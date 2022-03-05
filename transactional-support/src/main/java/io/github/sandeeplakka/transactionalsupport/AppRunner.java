package io.github.sandeeplakka.transactionalsupport;

import io.github.sandeeplakka.transactionalsupport.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {

    private final BookingService bookingService;

    public AppRunner(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) {
        bookingService.book("Alice", "Bob", "Carol");
        Assert.isTrue(bookingService.findAllBookings().size() == 3,
                "First booking should work with no problem");
        log.info("Alice, Bob and Carol have been booked.");

        try {
            bookingService.book("Chris", "Samuel");
        }catch (RuntimeException re){
            log.info("v--- Following exception is expected because 'Samuel' is  too big for the DB ---v");
            log.error(re.getMessage());
        }

        for(String person : bookingService.findAllBookings()){
            log.info("So far, "+person+" is booked");
        }
        log.info("You shouldn't see Chris and Samuel as Samuel is not eligible");
        Assert.isTrue(bookingService.findAllBookings().size() ==3,
                "'Samuel' should've triggered rollback for him and Chris");

        try {
            bookingService.book("Buddy", null);
        } catch (RuntimeException e) {
            log.info("v--- The following exception is expected because null is not " +
                    "valid for the DB ---v");
            log.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            log.info("So far, " + person + " is booked.");
        }
        log.info("You shouldn't see Buddy or null. null violated DB constraints, and " +
                "Buddy was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() == 3,
                "'null' should have triggered a rollback");

    }
}
