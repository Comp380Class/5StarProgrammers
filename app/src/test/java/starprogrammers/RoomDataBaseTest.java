package starprogrammers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class FilterRoomTest {
  Room testRoom = new Room("Test", "Room", 999, "Suite", "Queen", 1, 1, 1);

  @Test
  void RoomManager1InsertsToTable() {
    RoomDataBase.insertRoom(testRoom);
    assertTrue(RoomDataBase.doesRoomExist(testRoom.getRoomNumber()), "Room 999 should exist after being inserted.");
  }

  @Test
  void RoomManager2DeletesFromTable() {
    assertTrue(RoomDataBase.doesRoomExist(testRoom.getRoomNumber()));
    RoomDataBase.removeRoomFromTable((testRoom.getRoomNumber()));
    assertFalse(RoomDataBase.doesRoomExist(testRoom.getRoomNumber()));
  }

  public static ArrayList<Room> filterRooms() {
    ArrayList<Room> testRooms = RoomDataBase.filterRooms("Suite");
    return testRooms;
  }

  @ParameterizedTest
  @MethodSource(value = "filterRooms")
  void testRoomFilter(Room filteredRoom) {
    assertEquals("Suite", filteredRoom.getRoomType(), "Hotel contains 6 Suites");
  }
}
