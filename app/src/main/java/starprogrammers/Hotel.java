package starprogrammers;

import java.util.*;

public class Hotel {

  private Hotel() {
  }

  /** @return returns an ArrayList of all currently available rooms. */
  public static void printAllRooms() {
    ArrayList<Room> allRooms = RoomDataBase.getAllRooms();
    for (Room room : allRooms) {
      System.out.println(room);
    }
  }

  /** @return returns an ArrayList of all current reservations. */
  public static ArrayList<Reservation> getReservations() {
    // TODO: Add code for getting reservations after we figure out the db.
    return null;
  }

  /** @return returns an ArrayList of all currently reserved rooms. */
  public static void getReservedRooms() {
   ArrayList<Room> occupiedRooms = RoomDataBase.getAllOccupiedRooms();
   for (Room room : occupiedRooms){
    System.out.println(room);
   }
  }

  /**
   * Generates a text-user-interface with various reports that a Manager might
   * want to view.
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
          printAllRooms();
          break;
        case 2: // TODO:
          System.out.println("CALL getReservations() TO LOOK UP ALL RESERVATIONS IN DB");
          // getReservations();
          break;
        case 3: // TODO:
          System.out.println("FIND ROOMS THAT NEED TO BE CHECKED OUT TODAY");
          //User reservation manager to find rooms that should be checked out TODAY.
          break;
        case 4: // TODO:
          getReservedRooms();
          break;
        default:
          System.out.println("Invalid input. Please select one of the following options.");
      }
    }
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
   * Generates a text-user-interface with 2 options to select the user-type and 1
   * option to * quit
   * the program.
   */
  public static void main(String[] args) {
    RoomDataBase.initializationOfRoomTable();
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
          presentUserOptions(scnr);
          break;
        case 3:
          presentEmployeeOptions(scnr);
          break;
        default:
          System.out.println("\nInvalid input. Please try one of the following options.");
          break;
      }
    }
  }
}
