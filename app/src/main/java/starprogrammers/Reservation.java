package starprogrammers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Reservation {
    /** Represents the reservation number */
    private String reservationId;
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
    private static Period period;

    /** Represents id counter */
    private static int id = 0; 
    private int idCounter = 0;
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
      period = Period.between(checkIn, checkOut);
      
      id++; // each new reservation created increases id by 1
      idCounter = id;
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

    public int getId(){
      return idCounter;
    }

    public String getFirstName(){
      return customerFirstName;
    }

    public String getLastName(){
      return customerLastName;
    }

    public int getCustomerAge(){
      return customerAge;
    }

    public String getCustomerPaymentInfo(){
      return customerPaymentInfo;
    }

    public String getCustomerEmail(){
      return customerEmail;
    }

    public int getTotalOccupants(){
      return totalOccupants;
    }

    public int getRoomNumber(){
      return roomNumber;
    }

    public Date getCheckIn(){
      return checkIn;
    }

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
    static long totalDays() {
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
