package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;
import pl.wsb.hotel.services.TimeService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTests {
    private Hotel hotel;

    @BeforeEach
    public void setup() {
        hotel = new Hotel("Hilton");
    }

    @Test
    public void getName_returnsName() {
        assertEquals("Hilton", hotel.getName());
    }

    @Test
    public void setName_changesName() {
        hotel.setName("Else");
        assertEquals("Else", hotel.getName());
    }

    @Test
    public void addService_addsService() {
        hotel.addService(new TimeService("Time"));
        assertNotNull(hotel.getSpecialService(0));
    }

    @Test
    public void removeService_removesService() {
        var service = new TimeService("Time");
        hotel.addService(service);
        assertNotNull(hotel.getSpecialService(0));
        hotel.removeService(service);
        assertNull(hotel.getSpecialService(0));
    }

    @Test
    public void getSpecialService_returnsSpecialService() {
        var service = new TimeService("Time");
        hotel.addService(service);
        assertNotNull(hotel.getSpecialService(0));
    }

    @Test void getSpecialService_returnsNull() {
        assertNull(hotel.getSpecialService(0));
    }

    @Test
    public void addClient_addsClient() {
        assertNull(hotel.getClient(0));
        hotel.addClient("John", "Smith", LocalDate.now());
        assertNotNull(hotel.getClient(0));
    }

    @Test
    public void addClient_returnsNonEmptyUUID() {
        assertFalse(hotel.addClient("John", "Smith", LocalDate.now()).isEmpty());
    }

    @Test
    public void removeClient_removesClient() {
        assertNull(hotel.getClient(0));
        hotel.addClient("John", "Smith", LocalDate.now());
        var client = hotel.getClient(0);
        assertNotNull(client);
        hotel.removeClient(client);
        assertNull(hotel.getClient(0));
    }

    @Test
    public void getClient_returnsClient()
    {
        assertNull(hotel.getClient(0));
        hotel.addClient("John", "Smith", LocalDate.now());
        var client = hotel.getClient(0);
        assertNotNull(client);
    }

    @Test
    public void getClient_returnsNull()
    {
        assertNull(hotel.getClient(0));
    }

    @Test
    public void addNewReservation_throwsClientNotFoundException() {
        assertThrows(ClientNotFoundException.class, () -> hotel.addNewReservation("1", "1", LocalDate.now()));
    }

    @Test
    public void addNewReservation_throwsRoomNotFoundException() {
        var id = hotel.addClient("John", "Smith", LocalDate.now());
        assertThrows(RoomNotFoundException.class, () -> hotel.addNewReservation(id, "1", LocalDate.now()));
    }

    @Test
    public void addNewReservation_throwsRoomReservedException() throws ClientNotFoundException, RoomNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertThrows(RoomReservedException.class, () -> hotel.addNewReservation(clientId, roomId, LocalDate.now()));
    }

    @Test
    public void addNewReservation_returnNonEmptyUUID() throws ClientNotFoundException, RoomNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        var id = hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertFalse(id.isEmpty());
    }

    @Test
    public void addNewReservation_addsNewReservation() throws ClientNotFoundException, RoomNotFoundException {
        assertNull(hotel.getReservation(0));
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertNotNull(hotel.getReservation(0));
    }

    @Test
    public void removeReservation_removesReservation() throws ClientNotFoundException, RoomNotFoundException {
        assertNull(hotel.getReservation(0));
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        var reservation = hotel.getReservation(0);
        assertNotNull(reservation);
        hotel.removeReservation(reservation);
        assertNull(hotel.getReservation(0));
    }

    @Test
    public void getReservation_returnsReservation() throws ClientNotFoundException, RoomNotFoundException {
        assertNull(hotel.getReservation(0));
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertNotNull(hotel.getReservation(0));
    }

    @Test
    public void getReservation_returnsNull() {
        assertNull(hotel.getReservation(0));
    }

    @Test
    public void addRoom_addsRoom() {
        assertNull(hotel.getRoom(0));
        hotel.addRoom(1, 1, false, "");
        assertNotNull(hotel.getRoom(0));
    }

    @Test
    public void addRoom_returnNonEmptyUUID() {
        var id = "";
        id = hotel.addRoom(1, 1, false, "");
        assertFalse(id.isEmpty());
    }

    @Test
    public void removeRoom_removesRoom() {
        assertNull(hotel.getRoom(0));
        hotel.addRoom(1, 1, false, "");
        var room = hotel.getRoom(0);
        assertNotNull(room);
        hotel.removeRoom(room);
        assertNull(hotel.getRoom(0));
    }

    @Test
    public void getRoom_returnsRoom() {
        assertNull(hotel.getRoom(0));
        hotel.addRoom(1, 1, false, "");
        var room = hotel.getRoom(0);
        assertNotNull(room);
    }

    @Test
    public void getRoom_returnsNull() {
        assertNull(hotel.getRoom(0));
    }

    @Test
    public void getClientFullName_returnsEmpty() {
        assertTrue(hotel.getClientFullName("1").isEmpty());
    }

    @Test
    public void getClientFullName_returnsFullName() {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var client = hotel.getClient(0);
        assertEquals(client.getFullName(), hotel.getClientFullName(clientId));
    }

    @Test
    public void getNumberOfUnderageClients_returns0_whenNoClients() {
        assertEquals(hotel.getNumberOfUnderageClients(), 0);
    }

    @Test
    public void getNumberOfUnderageClients_returns0whenNoUnderageClients() {
        hotel.addClient("John", "Smith", LocalDate.now().minusYears(18));
        hotel.addClient("John", "Smith", LocalDate.now().minusYears(20));
        hotel.addClient("John", "Smith", LocalDate.now().minusYears(100));
        assertEquals(hotel.getNumberOfUnderageClients(), 0);
    }

    @Test
    public void getNumberOfUnderageClients_returns0whenUnderageClients() {
        hotel.addClient("John", "Smith", LocalDate.now().minusYears(1));
        hotel.addClient("John", "Smith", LocalDate.now().minusYears(17));
        hotel.addClient("John", "Smith", LocalDate.now().minusYears(100));
        assertEquals(hotel.getNumberOfUnderageClients(), 2);
    }

    @Test
    public void getRoomArea_return0whenNoRoomFound() {
        assertEquals(hotel.getRoomArea(""), 0);
    }

    @Test
    public void getRoomArea_returnCorrectValue() {
        var id = hotel.addRoom(1, 1, false, "");
        assertEquals(hotel.getRoomArea(id), 1);
    }

    @Test
    public void getNumberOfRoomsWithKingSizeBed_return0whenNoRooms() {
        assertEquals(hotel.getNumberOfRoomsWithKingSizeBed(0), 0);
    }

    @Test
    public void getNumberOfRoomsWithKingSizeBed_return0whenNoRoomsWithKSB() {
        hotel.addRoom(1, 1, false, "");
        hotel.addRoom(1, 0, false, "");
        assertEquals(hotel.getNumberOfRoomsWithKingSizeBed(0), 0);
    }

    @Test
    public void getNumberOfRoomsWithKingSizeBed_return0whenRoomsWithKSBOnOtherFloor() {
        hotel.addRoom(1, 1, true, "");
        hotel.addRoom(1, 0, false, "");
        assertEquals(hotel.getNumberOfRoomsWithKingSizeBed(0), 0);
    }

    @Test
    public void getNumberOfRoomsWithKingSizeBed_returnsCorrectCount() {
        hotel.addRoom(1, 1, true, "");
        hotel.addRoom(1, 1, false, "");
        hotel.addRoom(1, 0, true, "");
        hotel.addRoom(1, 0, true, "");
        assertEquals(hotel.getNumberOfRoomsWithKingSizeBed(0), 2);
    }

    @Test
    public void confirmReservation_throwsReservationNotFoundException() {
        assertThrows(ReservationNotFoundException.class, () -> hotel.confirmReservation(""));
    }

    @Test
    public void confirmReservation_confirmsReservation() throws ClientNotFoundException, RoomNotFoundException {
        assertNull(hotel.getReservation(0));
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        var reservation = hotel.getReservation(0);
        assertNotNull(reservation);
        assertFalse(reservation.isConfirmed());
        hotel.confirmReservation(reservation.getId());
        assertTrue(reservation.isConfirmed());
    }

    @Test
    public void confirmReservation_returnsReservationId() throws ClientNotFoundException, RoomNotFoundException {
        assertNull(hotel.getReservation(0));
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        var reservation = hotel.getReservation(0);
        assertNotNull(reservation);
        assertFalse(reservation.isConfirmed());
        var id = hotel.confirmReservation(reservation.getId());
        assertTrue(reservation.isConfirmed());
        assertEquals(id, reservation.getId());
    }

    @Test
    public void isRoomReserved_returnsTrue() throws RoomNotFoundException, ClientNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertTrue(hotel.isRoomReserved(roomId, LocalDate.now()));
    }

    @Test
    public void isRoomReserved_returnsFalse() throws RoomNotFoundException {
        var roomId = hotel.addRoom(1, 1, false, "");
        assertFalse(hotel.isRoomReserved(roomId, LocalDate.now()));
    }

    @Test
    public void isRoomReserved_throwsRoomNotFoundException() {
        assertThrows(RoomNotFoundException.class, () -> hotel.isRoomReserved("", LocalDate.now()));
    }

    @Test
    public void getNumberOfUnconfirmedReservation_returns0whenNoReservation() {
        assertEquals(0, hotel.getNumberOfUnconfirmedReservation(LocalDate.now()));
    }

    @Test
    public void getNumberOfUnconfirmedReservation_returns0whenAllReservationsConfirmed() throws ClientNotFoundException, RoomNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        var reservation = hotel.getReservation(0);
        assertNotNull(reservation);
        hotel.confirmReservation(reservation.getId());
        assertEquals(0, hotel.getNumberOfUnconfirmedReservation(LocalDate.now()));
    }

    @Test
    public void getNumberOfUnconfirmedReservation_returnsCorrectCount() throws ClientNotFoundException, RoomNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertEquals(1, hotel.getNumberOfUnconfirmedReservation(LocalDate.now()));
    }

    @Test
    public void getRoomIdsReservedByClient_throwsClientNotFoundException() {
        assertThrows(ClientNotFoundException.class, () -> hotel.getRoomIdsReservedByClient(""));
    }

    @Test
    public void getRoomIdsReservedByClient_returnsEmptyList() throws ClientNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        assertTrue(hotel.getRoomIdsReservedByClient(clientId).isEmpty());
    }

    @Test
    public void getRoomIdsReservedByClient_returnsRoomIds() throws ClientNotFoundException, RoomNotFoundException {
        var clientId = hotel.addClient("John", "Smith", LocalDate.now());
        var roomId = hotel.addRoom(1, 1, false, "");
        hotel.addNewReservation(clientId, roomId, LocalDate.now());
        assertFalse(hotel.getRoomIdsReservedByClient(clientId).isEmpty());
    }
}
