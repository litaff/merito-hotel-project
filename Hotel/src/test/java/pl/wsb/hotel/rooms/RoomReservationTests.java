package pl.wsb.hotel.rooms;

import org.junit.jupiter.api.Test;
import pl.wsb.hotel.clients.Client;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RoomReservationTests {
    @Test
    public void getDate_returnsDate() {
        // Arrange
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        LocalDate date = roomReservation.getDate();
        assertEquals(LocalDate.now(), date);
    }

    @Test
    public void setDate_setsDate() {
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        LocalDate newDate = LocalDate.now().plusDays(1);
        roomReservation.setDate(newDate);
        assertEquals(newDate, roomReservation.getDate());
    }

    @Test
    public void confirmReservation_setsIsConfirmed() {
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        roomReservation.confirmReservation();
        assertTrue(roomReservation.isConfirmed());
    }

    @Test
    public void isOverlapping_returnsTrue() {
        Room room = new Room("1", "1", 1, 1, false);
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                room);
        RoomReservation roomReservation2 = new RoomReservation("2",
                LocalDate.now(),
                new Client("2", "Jane", "Doe", LocalDate.now()),
                room);
        assertTrue(roomReservation.isOverlapping(roomReservation2));
    }

    @Test
    public void isOverlapping_returnsFalse() {
        Room room = new Room("1", "1", 1, 1, false);
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                room);
        RoomReservation roomReservation2 = new RoomReservation("2",
                LocalDate.now().plusDays(1),
                new Client("2", "Jane", "Doe", LocalDate.now()),
                room);
        assertFalse(roomReservation.isOverlapping(roomReservation2));
    }

    @Test
    public void isOverlapping_returnsFalseWhenDifferentRooms() {
        Room room = new Room("1", "1", 1, 1, false);
        Room room2 = new Room("2", "2", 1, 1, false);
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                room);
        RoomReservation roomReservation2 = new RoomReservation("2",
                LocalDate.now(),
                new Client("2", "Jane", "Doe", LocalDate.now()),
                room2);
        assertFalse(roomReservation.isOverlapping(roomReservation2));
    }

    @Test
    public void isOverlapping_returnsTrueWhenSameRoomAndDate() {
        Room room = new Room("1", "1", 1, 1, false);
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                room);
        RoomReservation roomReservation2 = new RoomReservation("2",
                LocalDate.now(),
                new Client("2", "Jane", "Doe", LocalDate.now()),
                room);
        assertTrue(roomReservation.isOverlapping(roomReservation2));
    }

    @Test
    public void getId_returnsId() {
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        assertEquals("1", roomReservation.getId());
    }

    @Test
    public void getRoom_returnsRoom() {
        Room room = new Room("1", "1", 1, 1, false);
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                room);
        assertEquals(room, roomReservation.getRoom());
    }

    @Test
    public void setRoom_setsRoom() {
        Room room = new Room("1", "1", 1, 1, false);
        Room room2 = new Room("2", "2", 1, 1, false);
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                room);
        roomReservation.setRoom(room2);
        assertEquals(room2, roomReservation.getRoom());
    }

    @Test
    public void getClient_returnsClient() {
        Client client = new Client("1", "John", "Doe", LocalDate.now());
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                client,
                new Room("1", "1", 1, 1, false));
        assertEquals(client, roomReservation.getClient());
    }

    @Test
    public void isConfirmed_returnsIsConfirmed() {
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        assertFalse(roomReservation.isConfirmed());
    }

    @Test
    public void isConfirmed_returnsTrue() {
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        roomReservation.confirmReservation();
        assertTrue(roomReservation.isConfirmed());
    }

    @Test
    public void isConfirmed_returnsFalse() {
        RoomReservation roomReservation = new RoomReservation("1",
                LocalDate.now(),
                new Client("1", "John", "Doe", LocalDate.now()),
                new Room("1", "1", 1, 1, false));
        assertFalse(roomReservation.isConfirmed());
    }
}
