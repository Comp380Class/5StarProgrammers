package starprogrammers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ReservationTest {

    Reservation res = new Reservation("Smith", "John",
    65, "123546489", 
    "johnsmith@gmail.com", 2, 206, 
    LocalDate.of(2022, 12, 1), 
    LocalDate.of(2022, 12, 3));
    Room room = new Room("Smith", "John", 206,
    "smoking", "King", 2, 50, 2);

    @Test
    void testGetCheckIn() {
        assertEquals(java.sql.Date.valueOf(LocalDate.of(2022, 12, 1)), res.getCheckIn(), "must be 2022,12,01");
    }

    @Test
    void testGetCheckOut() {
        assertEquals(java.sql.Date.valueOf(LocalDate.of(2022, 12, 3)), res.getCheckOut(), "must be 2022,12,03");
    }

    @Test
    void testGetCustomerAge() {
        assertEquals(65, res.getCustomerAge(), "must be 65");
    }

    @Test
    void testGetCustomerEmail() {
        assertEquals("johnsmith@gmail.com", res.getCustomerEmail(), "must be johnsmith@gmail.com");
    }

    @Test
    void testGetCustomerPaymentInfo() {
        assertEquals("123546489", res.getCustomerEmail(), "must be 123546489");
    }

    @Test
    void testGetFirstName() {
        assertEquals("John", res.getFirstName(), "must be John");
    }

    @Test
    void testGetLastName() {
        assertEquals("Smith", res.getLastName(), "must be Smith");
    }

    @Test
    void testGetName() {
        assertEquals("John Smith", res.getName(), "must be John Smith");
    }

    @Test
    void testGetRoomNumber() {
        assertEquals(206, res.getRoomNumber(), "must be 206");
    }

    @Test
    void testGetTotalOccupants() {
        assertEquals(2, res.getTotalOccupants(), "must be 2");
    }

    @Test
    void testTotalDays() {
        assertEquals(3, res.totalDays(), "must be 3");
    }

    @Test
    void testTotalPrice() {
        assertEquals(2, res.totalPrice(room), "must be 2");
    }
}
