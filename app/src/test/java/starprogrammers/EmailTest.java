package starprogrammers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EmailTest {
    Reservation res = new Reservation("Smith", "John",
    65, "123546489",
    "5starprogrammers@gmail.com", 2, 206, 
    LocalDate.of(2022, 12, 1), 
    LocalDate.of(2022, 12, 3));
    Room room = new Room("Smith", "John", 206,
    "smoking", "King", 2, 50, 2);
    Email email = new Email(res, room, -1);
    
    @Test
    void testReserve() {
        assertTrue(email.sendEmail("reserve"), "should send reservation email without error");
    }

    @Test
    void testCancelReservation() {
        assertTrue(email.sendEmail("cancel"), "should send cancellation email without error");
    }

    @Test
    void testChangeReservation() {
        assertTrue(email.sendEmail("change"), "should send changes email without error");
    }
}
