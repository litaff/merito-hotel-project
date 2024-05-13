package pl.wsb.hotel.clients;

import org.junit.jupiter.api.Test;
import pl.wsb.hotel.rooms.Room;
import pl.wsb.hotel.rooms.RoomReservation;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTests {

    @Test
    public void getAge_returnsCorrectAge() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20));
        assertEquals(20, client.getAge());
    }

    @Test
    public void getFullName_returnsCorrectFullName() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20));
        assertEquals("John Doe", client.getFullName());
    }

    @Test
    public void getTravelPurpose_returnsCorrectTravelPurpose() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        assertEquals("Business", client.getTravelPurpose());
    }

    @Test
    public void isUnderAged_returnsTrueForUnderAged() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(17));
        assertTrue(client.isUnderAged());
    }

    @Test
    public void isUnderAged_returnsFalseForAdult() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(18));
        assertFalse(client.isUnderAged());
    }

    @Test
    public void getNeedsAccessibilityFeature_returnsTrueForAccessibilityFeature() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), true, "Business");
        assertTrue(client.getNeedsAccessibilityFeature());
    }

    @Test
    public void getNeedsAccessibilityFeature_returnsFalseForNoAccessibilityFeature() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        assertFalse(client.getNeedsAccessibilityFeature());
    }

    @Test
    public void getReservationHistory_returnsEmptyListForNewClient() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        assertTrue(client.getReservationHistory().isEmpty());
    }

    @Test
    public void getReservationHistory_returnsCorrectList() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        var room = new Room("1", "", 1, 1, false);
        var reservation = new RoomReservation("1", LocalDate.now(), client, room);
        assertEquals(reservation, client.getReservationHistory().get(0));
    }

    @Test
    public void setFirstName_setsCorrectFirstName() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        client.setFirstName("Jane");
        assertEquals("Jane", client.getFirstName());
    }

    @Test
    public void setLastName_setsCorrectLastName() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        client.setLastName("Smith");
        assertEquals("Smith", client.getLastName());
    }

    @Test
    public void setTravelPurpose_setsCorrectTravelPurpose() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        client.setTravelPurpose("Leisure");
        assertEquals("Leisure", client.getTravelPurpose());
    }

    @Test
    public void setNeedsAccessibilityFeature_setsCorrectAccessibilityFeature() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        client.setNeedsAccessibilityFeature(true);
        assertTrue(client.getNeedsAccessibilityFeature());
    }

    @Test
    public void setUnderAged_setsCorrectUnderAged() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        client.setUnderAged(true);
        assertTrue(client.isUnderAged());
    }

    @Test
    public void addReservationToHistory_addsReservationToHistory() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        var room = new Room("1", "", 1, 1, false);
        var reservation = new RoomReservation("1", LocalDate.now(), client, room);
        client.addReservationToHistory(reservation);
        assertEquals(reservation, client.getReservationHistory().get(0));
    }

    @Test
    public void getId_returnsCorrectId() {
        var client = new Client("1", "John", "Doe", LocalDate.now().minusYears(20), false, "Business");
        assertEquals("1", client.getId());
    }
}
