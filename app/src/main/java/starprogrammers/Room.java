//Comp380L
//a)To create room class for hotel
//b)Aug 05, 2022 (date of created code) // Aug 16, 2022 (date of added javadocs)
//c)Hillard Staggs
//d)To create room for hotel 
//e)important to have string and int to able know what specific for room
//f)public room with this. are important so can represents for hotel
//g)used string and int that are required to have in this code because that plans from UML diagram
//after return with string to able show the more details for room

import java.io.PrintWriter;
import java.util.Scanner;

//a public class represents show rooms at the hotel like checking the room and looking 
//around to interesting in what hotel will offer for the room that customers can stay there at hotel
/** 
 * this methods represents showing descriptions of rooms at a hotel.
 * Information for customer room if want to book that room at a hotel
 * Type are specific for room and bed type to able fit how many people 
 * */

public class Room implements Comparable<Room> { 
    private String customerName; 
    private int roomNumber;
    private String roomType;
    private String bedType;
    private int bedQuantity;
    private int roomPrice;
    private int numberOfOccupants;

    /**
     * To create a new instance of class room
     */
    public Room() { //a room class that represents to checking one of the room at a hotel

    }
    //each room has a variable to represent the room on which type and information from checking the room
    public Room(String customerName,int roomNumber,String roomType,String bedType,int bedQuantity,int roomPrice,int numberOfOccupants) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.bedQuantity = bedQuantity;
        this.roomPrice = roomPrice;
        this.numberOfOccupants = numberOfOccupants;
    }

    /**
     * to create the method if changing the selection of room type
     * to able to call the type of bed and room after this method if want to change
     */
    public void changeRoomType(){

    }

    public int getnumberOfOccupants() { return numberOfOccupants; }

    /**
     * return the information for room 
     * @return the integer to used in this room for hotel
     */
    public String customerName(){
        return customerName;
    }

    public String roomType(){
        return roomType;
    }

    public String bedType(){
        return bedType;
    }

    /**
     * To scan the input to able to get the more details after selecting the room
     */
    public void readFrom(Scanner input) { //checking the next input as int
        roomNumber = input.nextInt(); 
        input.useDelimiter("/");
        input.reset();
        bedQuantity = input.nextInt(); //checking or scanning the quantity of bed
        roomPrice = input.nextInt(); //checking or scanning the price to book a room at the hotel
        numberOfOccupants = input.nextInt();//checking how many people can stay in that room
    }

    /**
     * to get scanning for output in each of output.print
     * @param output
     */
    public void writeTo(PrintWriter output) { //print an information for room details
        output.print(customerName); //each of output show what details for specific in room at hotel
        output.print(" ");
        output.print(roomNumber); //details of room number
        output.print(" "); 
        output.print(roomType); //details of type room like has suite in that room or something
        output.print(" ");
        output.print(bedType); //queen, king, sofebed, or full
        output.print(" ");
        output.print(bedQuantity); //how many of the quantities does the bed have in one room?
        output.print(" ");
        output.print(roomPrice); //a price to book a room at a hotel
        output.print(" ");
        output.println(numberOfOccupants); //number of occupants in per room
    }

    public String toString() { //scanned from the output
        return customerName + "(" + numberOfOccupants + "):" +roomType + " " + bedType; //this is where if the user want to book for that specific room
    }

    @Override
    public int compareTo(Room t) {
        if(roomPrice <= t.bedQuantity)
            return -1;
        else if(bedQuantity >= t.roomPrice)
            return 1;
        return 0;
    }
}