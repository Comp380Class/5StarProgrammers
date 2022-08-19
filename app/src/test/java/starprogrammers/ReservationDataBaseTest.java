package starprogrammers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ReservationDataBaseTest {
    Reservation res = new Reservation("Smith", "John",
    65, "123546489", 
    "johnsmith@gmail.com", 2, 206, 
    LocalDate.of(2022, 12, 1), 
    LocalDate.of(2022, 12, 3));
    Room room = new Room("Smith", "John", 206,
    "smoking", "King", 2, 50, 2);
    ReservationDataBase resdb = new ReservationDataBase();
    
    @Test
    void testCancelReservation() {
        resdb.cancelReservation(5);
        assertEquals(null, ReservationDataBase.getSpecificReservation(5), "must be null");
    }
    
    @Test
    void getReservation(){
        assertEquals(res.getName(), ReservationDataBase.getSpecificReservation(10).getName(), "must be john smith's reservation");
    }
}
