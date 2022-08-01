package starprogrammers;

import java.util.Scanner;
import java.util.ArrayList;

public class Hotel {
  public Hotel() {}

  // private ArrayList<Room> availableRooms;

  // public ArrayList<Room> getAvailableRooms(){
  // TODO: Add code for getting rooms once we figure out how we're querying to DB
  // }

  // public void generateManagerReport(){
  // TODO: Add code for generating manager reports once we figure out the DB.
  // }

  // public ArrayList<Reservation> getReservations(){
  // TODO: Add code for getting reservations after we figure out the db.
  // }

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
          System.out.println("\nBook Room operations");
          // TODO: Need to fix this when we figure out the room and DB ops.
          break;
        case 3:
          System.out.println("\nManagerial functions in here");
          // TODO: Put managerial functions here. Perhaps need user/pw for mngr?
          break;
        default:
          System.out.println("\nInvalid input. Please try one of the following options.");
      }
    }
  }
}
