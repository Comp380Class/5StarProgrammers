//Comp380L
//a)To create room class for hotel
//b)Aug 05, 2022 (date of created code) // Aug 16, 2022 (date of added javadocs)
//c)Hillard Staggs
//d)To create room for hotel 
//e)important to have string and int to able know what specific for room
//f)public room with this. are important so can represents for hotel
//g)used string and int that are required to have in this code because that plans from UML diagram
//after return with string to able show the more details for room

package starprogrammers;

import java.io.PrintWriter;
import java.util.Scanner;

//a public class represents show rooms at the hotel like checking the room and looking 
//around to interesting in what hotel will offer for the room that customers can stay there at hotel
/**
 * this methods represents showing descriptions of rooms at a hotel.
 * Information for customer room if want to book that room at a hotel
 * Type are specific for room and bed type to able fit how many people
 */

public class Room implements Comparable<Room> {
  private String firstName;
  private String lastName;
  private int roomNumber;
  private String roomType;
  private String bedType;
  private int bedQuantity;
  private int roomPrice;
  private int numberOfOccupants;

  /**
   * To create a new instance of class room
   */

  public Room() { // a room class that represents to checking one of the room at a hotel
  }

  /**
   * Constructor for Room object.
   * @param lastName String representing customer's last name.
   * @param firstName String representing customer's first name.
   * @param roomNumber int representing Room's number.
   * @param roomType String representing room type.
   * @param bedType String representing bed type.
   * @param bedQuantity int representing number of beds in the room.
   * @param roomPrice int representing the price of the room.
   * @param numberOfOccupants int representing the number of occupants that should be in the room.
   */
  public Room(String lastName, String firstName, int roomNumber, String roomType, String bedType, int bedQuantity,
      int roomPrice, int numberOfOccupants) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    this.bedType = bedType;
    this.bedQuantity = bedQuantity;
    this.roomPrice = roomPrice;
    this.numberOfOccupants = numberOfOccupants;
  }

  public int getnumberOfOccupants() {
    return numberOfOccupants;
  }
/**
 * Returns customer's first and last name.
 * @return customer's first and last name.
 */
  public String customerName() {
    return firstName + " " + lastName;
  }

  public String getRoomType() {
    return roomType;
  }

  public String getBedType() {
    return bedType;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public int getPrice() {
    return roomPrice;
  }

  public String getFirstName() {

    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getBedQuantity() {
    return bedQuantity;
  }

  /**
   * To scan the input to able to get the more details after selecting the room
   */

  public void readFrom(Scanner input) {
    roomNumber = input.nextInt();
    input.useDelimiter("/");
    input.reset();
    bedQuantity = input.nextInt();
    roomPrice = input.nextInt();
    numberOfOccupants = input.nextInt();
  }

  /**
   * to get scanning for output in each of output.print
   * 
   * @param output
   */
  public void writeTo(PrintWriter output) { // print an information for room details
    output.print(firstName); // print first name
    output.print(" ");
    output.print(lastName); // print last name
    output.print(" ");
    output.print(roomNumber); // details of room number
    output.print(" ");
    output.print(roomType);// details of type room like has suite in that room or something
    output.print(" ");
    output.print(bedType); // queen, king, sofebed, or full
    output.print(" ");
    output.print(bedQuantity);// how many of the quantities does the bed have in one room?
    output.print(" ");
    output.print(roomPrice);// a price to book a room at a hotel
    output.print(" ");
    output.println(numberOfOccupants); // number of occupants in per room
  }

  public String toString() {
    return "Room Number: " + roomNumber + " " + "Number of occupants allowed: " + numberOfOccupants + " Room Type: "
        + roomType + " Bed Type: " + bedType; // this is where if the user want to book for that specific room
  }

  @Override
  public int compareTo(Room t) {
    if (roomPrice <= t.bedQuantity)
      return -1;
    else if (bedQuantity >= t.roomPrice)
      return 1;
    return 0;
  }

  /**
   * Returns a string containing room information.
   * 
   * @return a string containing room information.
   */
  public String roomInfo() { // pulling the details for room
    return "\nPrice/Night: "
        + roomPrice
        + "\nType of room: "
        + roomType
        + "\nBed Quantity: " + bedQuantity
        + "\nRoom Number: " + roomNumber;
  }
}