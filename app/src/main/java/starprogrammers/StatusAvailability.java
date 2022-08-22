//to create status available for room at hotel
//Created code by Aug 18, 2022
//Hillard Staggs
//this class can fill up information to check the status of rooms and get to know if 
//it was available
import java.io.PrintWriter;
import java.util.Scanner;

public class StatusAvailability {
  private String firstName;
  private String lastName;
  private int statusRoom;
  private int CheckAvail;
  private int dateAvail;
    
    /**
    * To create a new instance of class status
    */

  public StatusAvailability() { // a room class that represents to checking status of available
  }

  public StatusAvailability(String lastName, String firstName, int statusRoom, int CheckAvail, int dateAvail) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.statusRoom = statusRoom;
    this.CheckAvail = CheckAvail;
    this.dateAvail = dateAvail;
  }

  public int getAvailability() { 
    return dateAvail;
  }
/**
 * Returns customer's first and last name.
 * @return customer's first and last name.
 */
  public String customerName() {
    return firstName + " " + lastName;
  }

  public int statusRoom() {
    return statusRoom;
  }

  public int CheckAvail() {
    return CheckAvail;
  }

  public int dateAvail(){
    return dateAvail; 
  }
  /**
   * To scan the input for date of availability
   */

  public void readFrom(Scanner input) {
    statusRoom = input.nextInt();
    input.useDelimiter("/");
    input.reset();
    CheckAvail = input.nextInt();
    dateAvail = input.nextInt();
  }

  /**
   * to get scanning for output in each of output.print
   * 
   * @param output will print each output to show the status of information for the room
   */
  public void writeTo(PrintWriter output) { // print an information for status details
    output.print(firstName); // print first name
    output.print(" ");
    output.print(lastName); // print last name
    output.print(" ");
    output.print(statusRoom); // details of status room
    output.print(" ");
    output.print(CheckAvail);// check which room is available
    output.print(" ");
    output.print(dateAvail); // date of what room will be available
    output.print(" ");
  }

  public String toString() {
    return "statusRoom: " + statusRoom + " " + "dateAvail: " + dateAvail;// this is where if the user want to book for that specific room
  }

  @Override //run to check if return to get information by check available
  public int run(StatusAvailability t) {
    if (0<= statusRoom && t.CheckAvail <= 1)
      return 1;
    else if (CheckAvail >= t.statusRoom)
      return 1;
    return 0;
  }

  /**
   * Returns a string containing status information.
   * @return a string containing status information.
   */
  public String roomInfo() { // pulling the details for status available
    return "\nstatus of room: "
        + statusRoom
        + "\ncheck availability: "
        + CheckAvail
        + "\ndateAvail: " + dateAvail;
  }
}