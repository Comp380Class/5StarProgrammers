package starprogrammers;

import java.time.LocalDate;
import java.util.Scanner;

public class Hotel {

  public Hotel() {}

  /** @return returns an ArrayList of all currently available rooms. */
  // public ArrayList<Room> getAvailableRooms(){
  // TODO: Add code for getting rooms once we figure out how we're querying to DB
  //	ReservationGenerator.getAvailableRooms();
  // }
  /** @return returns an ArrayList of all current reservations. */
  // public ArrayList<Reservation> getReservations(){
  // TODO: Add code for getting reservations after we figure out the db.
  // }

  /** @return returns an ArrayList of all currently reserved rooms. */
  // public ArrayList<Room> getReservedRooms(){
  // TODO: Call the method from the class managing the rooms.
  // }

  /**
   * Generates a text-user-interface with various reports that a Manager might want to view.
   *
   * @param Scanner object passed from the main method.
   */
  public static void generateManagerReport(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Back");
      System.out.println("1) All available rooms");
      System.out.println("2) All current reservations.");
      System.out.println("3) All Rooms that need to be Checked-Out.");
      System.out.println("4) All reserved rooms");
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1: // TODO:
          System.out.println("CALL getAvailableRooms()  TO LOOK UP ALL ROOMS IN DB");
          break;
        case 2: // TODO:
          System.out.println("CALL getReservations() TO LOOK UP ALL RESERVATIONS IN DB");
          break;
        case 3: // TODO:
          System.out.println("FIND ROOMS THAT NEED TO BE CHECKED OUT TODAY");
          // getUnavailableRooms()?
          // with checkOut today?
          break;
        case 4: // TODO:
          System.out.println("FIND ROOMS THAT ARE CURRENTLY OCCUPIED");
          break;
        default:
          System.out.println("Invalid input. Please select one of the following options.");
      }
    }
  }
  /**
   * Receives input from a user to gather customer information.
   *
   * @param Scanner object passed in by the main method.
   */
  private static void receiveCustomerInformation(Scanner scnr) {
    System.out.println("Enter Name: ");
    String customerName = scnr.next();
    System.out.println("Enter Age: ");
    int customerAge = scnr.nextInt();
    System.out.println("Enter payment information");
    String customerPaymentInfo = scnr.nextLine();
    System.out.println("Enter Email: ");
    String customerEmail = scnr.next();
    System.out.println("Enter number of occupants: ");
    int numberOfOccupants = scnr.nextInt();
    System.out.println("Enter check in date(YYYY MM DD)");
    int checkInYear = scnr.nextInt();
    int checkInMonth = scnr.nextInt();
    int checkInDay = scnr.nextInt();
    LocalDate checkInDate = LocalDate.of(checkInYear, checkInMonth, checkInDay);
    System.out.println("Enter check out date (YYYY MM DD)");
    int checkOutYear = scnr.nextInt();
    int checkOutMonth = scnr.nextInt();
    int checkOutDay = scnr.nextInt();
    LocalDate checkOutDate = LocalDate.of(checkOutYear, checkOutMonth, checkOutDay);

    // TODO: NEED TO DO SOMETHING WITH THIS CUSTOMER INFORMATION.
  }
  /**
   * Generates a text-user-interface with various options that users of this application may want
   * access to.
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Quit");
      System.out.println("1) Book room");
      System.out.println("3) Manager Options");
      int userInput = scnr.nextInt();

      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          receiveCustomerInformation(scnr);
          break;
        case 3:
          generateManagerReport(scnr);

          break;
        default:
          System.out.println("\nInvalid input. Please try one of the following options.");
      }
    }
  }
}
