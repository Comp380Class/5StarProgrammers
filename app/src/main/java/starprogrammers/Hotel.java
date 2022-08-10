package starprogrammers;

import java.time.LocalDate;
import java.util.*;

public class Hotel {

  private Hotel() {}

  private static ArrayList<Room> availableRooms = new ArrayList<Room>();

  /** @return returns an ArrayList of all currently available rooms. */
  public static ArrayList<Room> getAvailableRooms() {
    // TODO: Add code for getting rooms once we figure out how we're querying to DB
    //	ReservationGenerator.getAvailableRooms();
    return availableRooms;
  }
  /** @return returns an ArrayList of all current reservations. */
  public ArrayList<Reservation> getReservations() {
    // TODO: Add code for getting reservations after we figure out the db.
	  return null;
  }

  /** @return returns an ArrayList of all currently reserved rooms. */
  public ArrayList<Room> getReservedRooms() {
    // TODO: Call the method from the class managing the rooms.
	  return null;
  }

  /**
   * Generates a text-user-interface with various reports that a Manager might want to view.
   *
   * @param Scanner object passed from the main method.
   */
  private static void generateManagerReport(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Back");
      System.out.println("1) All available rooms");
      System.out.println("2) All current reservations.");
      System.out.println(
          "3) All Rooms that need to be Checked-Out."); // Room XXX needs to check out.
      System.out.println("4) All reserved rooms"); // Room reserved by X from checkIn to Checkout.
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1: // TODO:
          System.out.println("CALL getAvailableRooms()  TO LOOK UP ALL ROOMS IN DB");
          getAvailableRooms();
          break;
        case 2: // TODO:
          System.out.println("CALL getReservations() TO LOOK UP ALL RESERVATIONS IN DB");
          // getReservations();
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
   * Presents a text user interface for customers.
   *
   * @param scanner object passed by main method.
   */
  private static void presentUserOptions(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Go back");
      System.out.println("1) Book a room");
      System.out.println("2) View reservation");
      System.out.println("3) Change reservation");
      System.out.println("4) Cancel reservation");
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          User.bookRoom();
          break;
        case 2:
          User.viewReservation();
          break;
        case 3:
          User.changeReservation();
          break;
        case 4:
          User.cancelReservation();
          break;
        default:
          System.out.println("Invalid input. Try one of the following options: ");
          break;
      }
    }
  }
  /**
   * Presents a text user interface for employee options and manager reports.
   *
   * @param Scanner object passed by main method.
   */
  private static void presentEmployeeOptions(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Go back");
      System.out.println("1) Generate manager reports");
      System.out.println("2) Change Customer Room");
      System.out.println("3) Cancel Customer Reservation");
      System.out.println("4) Check Custromer in");
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          generateManagerReport(scnr);
          break;
        case 2:
          Manager.changeRoomReservation();
          break;
        case 3:
          Manager.cancelRoomReservation();
          break;
        case 4:
          Manager.checkCustomerIn();
          break;
        default:
          System.out.println("Invalid input. Please try one of the following options");
          break;
      }
    }
  }

  /**
   * Generates a text-user-interface with 2 options to select the user-type and 1 option to * quit
   * the program.
   */
  public static void main(String[] args) {
    createHardCodedRoom();
    Scanner scnr = new Scanner(System.in);
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Quit");
      System.out.println("1) Log in as user");
      System.out.println("3) Log in as employee");
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          // create user object.
          // user should have a menu of their options.
          // user chooses "book room" gather customer information.
          presentUserOptions(scnr);
          break;
        case 3:
          // create manager object.
          // manager should have menu of their options.
          presentEmployeeOptions(scnr);
          break;
        default:
          System.out.println("\nInvalid input. Please try one of the following options.");
          break;
      }
    }
  }
  /** Hard coded room just used only for testing and integration. REMOVE BEFORE PROGRAM RELEASE. */
  private static void createHardCodedRoom() {
    Room testRoom = new Room("Unassigned", 101, "Suite", "King", 1, 50, 2);
    availableRooms.add(testRoom);
  }
}
