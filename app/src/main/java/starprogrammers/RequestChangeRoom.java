//to create request change room for hotel
//Created code by Aug 17, 2022
//Hillard Staggs
//this class is able to fill up information to request a change a new room will server to 
//create a form to request change new room and in the processing of room to change

import java.io.PrintWriter;
import java.util.Scanner;

//public class RequestChangeRoom will allow requesting change a room
/**
 * this method represents requesting a change room by just filling up the 
 * name and room number to be able to change a room from request.
 */
public class RequestChangeRoom {
    private String name; //fill it up name
    private int roomNumber; //fill it up a room number that want to change from request
    private ObservableList<Request> ChangeRoom; 

    /**
     * this will allow to able to change a room 
     */
    public RequestChangeRoom() { 
        ChangeRoom = ChangeRoom.observableArrayList();
    }

    /**
     * will return name once request to change a room
     * @return return name to fill it up for request
     */
    public String getName() { 
        return name; 
    }

    /**
     * These methods will allow to able to change room after request.
     * check to see if able to success for request to change room
     * @param newChangeRoom
     * @return list if already successful to change
     */
    public boolean allowsChangeRoom(Request newChangeRoom) {
        if(newChangeRoom.getName() > roomNumber)
            return false;
        for(Request e : ChangeRoom) {
            if(e.compareTo(newChangeRoom) == 0)
                return false;
        }
        return true;
    }

    /**
     * processing of changing new room
     * @param newChangeRoom
     */
    public void addReservation(Request newChangeRoom) {
        ChangeRoom.add(newChangeRoom);
        ChangeRoom.sort(ChangeRoom);
    }

    /**
     * to processing of able approve the request to change the room
     * @param toRemove return to remove from previous room to able change to a new one
     */
    public void removeReservation(Request toRemove) {
        ChangeRoom.remove(toRemove);
    }

    /**
     * scanning the request of details to able change new room
     * @param input list of details
     */
    public void readFrom(Scanner input) {
        //Details of change room
        name = input.next() + input.nextLine();
        roomNumber = input.nextInt();
        int howMany = input.nextInt();
        for(int n = 0;n < howMany;n++) {
            Request nextChangeRoom = new ChangeRoom();
            nextChangeRoom.readFrom(input);
            ChangeRoom.add(nextChangeRoom);
        }
        ChangeRoom.sort(ChangeRoom);
    }

    //print of details for request to change room
    public void writeTo(PrintWriter output) {
        output.println(name);
        output.println(roomNumber);
        int howMany = ChangeRoom.size();
        output.println(howMany);
        for(int n = 0;n < howMany;n++)
        ChangeRoom.get(n).writeTo(output);
    }

    /**
     * create and return a change room with information 
     * @return representing the room that the customer wanted to change
     */
    public ObservableList<Request> getChangeRoom() {
        return ChangeRoom; }
}