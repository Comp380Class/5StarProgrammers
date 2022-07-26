package starprogrammers;

/**
 * 08/01/2022
 * Erin Maldonado
 * Reservation class is used to create a reservation object
 * and stores customer information including: check in and
 * check out dates, room numbers, total occupants, customer's
 * name and age.
 * 
 */

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

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

    /** Represents the length of stay */
    private Period period;

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
      this.period = Period.between(checkIn, checkOut);
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
     * Gets the customer's first name
     * @return String
     */
    public String getFirstName(){
      return customerFirstName;
    }

    /**
     * Gets customer's last name
     * @return String
     */
    public String getLastName(){
      return customerLastName;
    }

    /**
     * Gets customer's age 
     * @return int
     */
    public int getCustomerAge(){
      return customerAge;
    }

    /**
     * Gets customer payment info
     * @return String
     */
    public String getCustomerPaymentInfo(){
      return customerPaymentInfo;
    }

    /**
     * Gets customer's email
     * @return String
     */
    public String getCustomerEmail(){
      return customerEmail;
    }

    /**
     * Gets total number of occupants
     * @return int
     */
    public int getTotalOccupants(){
      return totalOccupants;
    }

    /**
     * Gets room number
     * @return int
     */
    public int getRoomNumber(){
      return roomNumber;
    }

    /**
     * Gets check in date
     * @return Date
     */
    public Date getCheckIn(){
      return checkIn;
    }

    /**
     * Gets check out date
     * @return Date
     */
    public Date getCheckOut(){
      return checkOut;
    }

    /**
     * Converts LocalDate to Date
     * @param dateToConvert
     * @return Date object
     */
    public Date convertLocalDate(LocalDate dateToConvert){
        return java.sql.Date.valueOf(dateToConvert);
    }

    /**
     * Gets the customer's name
     * @return customer name
     */
    public String getName(){
      return customerFirstName + " " + customerLastName;
    }

    /**
     * Gets the customer's email 
     * @return email addresss
     */
    public String getEmail(){
      return customerEmail;
    }

    /**
     * String with reservation body
     * @return string with body for email
     */
    public String resString(){
      return "Hello " + customerFirstName + ", \n"
      + "Your reservation is confirmed!\n"
      + "Thank you for choosing our hotel. Below you will find your reservation details."
      + "If you would like to change or cancel your reservation"
      + " please let us know!\n\n";
    }

    /**
     * Email for confirming reservation
     * @param room
     * @return string with body for email
     */
    public String confirmationEmail(Room room){
      return resString()
          + "Arrival Date: " + checkIn
          + "\nDeparture Date: " + checkOut
          + "\n\nNumber of guests: " + totalOccupants
          + "\nTotal nights: " + totalDays() + "\n"
          + room.roomInfo()
          + "\nTotal Cost: " + totalPrice(room);
    }

    /**
     * Email for cancelling reservation
     * @param room
     * @return string with body for email
     */

    public String cancellationEmail(Room room){
      return "Hello " + customerFirstName + ", \n"
          + "Your reservation is now cancelled.\n"
          + "You will be refunded to your original payment at : " + customerPaymentInfo; 
    }

    /**
     * Email for changing reservation
     * @param room
     * @return string with body for email
     */
    public String changeEmail(Room room){
      return resString()
          + "Updated Reservation info"
          + "\nArrival Date: " + checkIn
          + "\nDeparture Date: " + checkOut
          + "\n\nNumber of guests: " + totalOccupants
          + "\nTotal nights: " + totalDays() + "\n"
          + room.roomInfo()
          + "\nTotal Cost: " + totalPrice(room);
    }

   /**
    * Takes check in and check out to get length of stay
    * @return the total number of days for stay
    */
    public long totalDays() {
      long years = period.getYears();
      long months = period.getMonths();
      long days = period.getDays();
  
      return (years*365)+(months*30)+days;
    }

    /**
     * @param room room which will be booked
     * @return total price of stay
     */
    public int totalPrice(Room room){
      int days = (int) totalDays();
      return days * room.getPrice();
    }
}
