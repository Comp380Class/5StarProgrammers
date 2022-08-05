package starprogrammers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Scanner;
/** 
    A user is able to access and the necessary functions of the hotel such as search for the type of room they desire,
     book a reservation, and view, change or cancel their reservation
*/
public class User {
    /**
        user selects a room from the list of available rooms displayed by program, and a new reservation is made under the user's name 
     */
    void bookRoom(){
        String name, emailAddr, payment;
        int age, partyNum;
        Date checkIn, checkOut;
        Scanner input = new Scanner(System.in);
        // user inputs check in and check out dates then selects type of room

        //TODO: Create GUI to allow user to input dates and select a type of room

        // program displays whether room is available, if so prompt user for info(name, age, email address, # of people, payment, check in & out dates)
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter age: ");
        age = input.nextInt();
        System.out.print("Enter number of people in party: ");
        partyNum = input.nextInt();
        System.out.print("Enter name: ");
        // if all prompts successfully completed, create new reservation and email confirmation to user
    }

    /**
        user selects a type of room offered, then program displays a list of rooms that match the catagory
     */
    void searchForRoomType(){}

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then their reservation is deleted from the database
     */
    void cancelReservation(){}

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then they are given the option to request a different type of room
     */
    void changeReservation(){}

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then information regarding their reservation is displayed
     */
    void viewReservation(){}
}

class manager extends User{

    /**
        user selects reservation from database then selects an unbooked room to replace current room
     */
    void changeRoomReservation(){}

    /**
        user selects reservation from database, reservation is then deleted from database
     */
    void cancelRoomReservation(){}

    /** 
        user selects reservation (or booked room?) and change occupied(or checked-in flag?) to true
    */
    void checkCustomerIn(){}
}