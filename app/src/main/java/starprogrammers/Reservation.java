package starprogrammers;

import java.sql.Date;
import java.time.LocalDate;

public class Reservation {
    /** Represents customer first name */
    private String customerFirstName;
    /** Represents customer last name */
    private String customerLastName;
    /** Represents customer age */
    private int customerAge;
    /** Represents customer payment info */
    private String customerPaymentInfo;
    /** Represents customer email */
    private String customerEmail;
    /** Represents number of occupants in room */
    private int totalOccupants;
    /* Represents room number*/
    private int roomNumber;
    /** Represents check in date */
    private Date checkIn;
    /** Represents check out date */
    private Date checkOut;
  
    /**
     * Constructs a Reservation with customer information.
     *
     * @param lastName the customer booking room
     * @param firstName the customer's first name
     * @param customerAge the customer's age
     * @param customerPaymentInfo the customer's payment info
     * @param customerEmail the customer's email
     * @param totalOccupants the number of occupants in a room
     * @param roomNumber the number of the room
     * @param checkIn Customer's check in date.
     * @param checkOut Customer's check out date.
     */
    Reservation(
        String lastName,
        String firstName,
        int customerAge,
        String customerPaymentInfo,
        String customerEmail,
        int totalOccupants,
        int roomNumber,
        LocalDate checkIn,
        LocalDate checkOut) {
      this.customerLastName = lastName;
      this.customerFirstName = firstName;
      this.customerAge = customerAge;
      this.customerPaymentInfo = customerPaymentInfo;
      this.customerEmail = customerEmail;
      this.totalOccupants = totalOccupants;
      this.roomNumber = roomNumber;
      this.checkIn = convertLocalDate(checkIn);
      this.checkOut = convertLocalDate(checkOut);
    }
  
    @Override
    public String toString() {
      return customerLastName
          + " "
          + customerFirstName
          + " has a confirmed reservation for room number "
          + roomNumber
          + ". Check in date of "
          + checkIn
          + " and check out: "
          + checkOut;
    }
  
    /**
     * Checks to see if check out date is after check in date
     * @return 1 if check out date is before check in date 0 if same date and -1 if after check in 
     */
    public int compareDates(){
        return checkIn.compareTo(checkOut);
    }

    /**
     * Converts LocalDate to Date
     * @param dateToConvert
     * @return Date object
     */
    public Date convertLocalDate(LocalDate dateToConvert){
        return java.sql.Date.valueOf(dateToConvert);
    }

    /** TODO */
    public void sendConfirmation() {}
  }
