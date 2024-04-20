package pl.wsb.hotel.rooms;

import pl.wsb.hotel.clients.Client;

import java.time.LocalDate;
import java.util.Objects;

public class RoomReservation {
    private String id;
    private LocalDate date;
    private boolean isConfirmed; // Confirmation has no dedicated setter, as, once confirmed, the reservation should either stay of be removed, if it was cancelled
    private Client client; // pl.wsb.hotel.client.Client has no setter, as the reservation should be deleted when client is to be changed.
    private Room room;

    public RoomReservation(String id, LocalDate date, Client client, Room room) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.room = room;
        isConfirmed = false;
        client.addReservationToHistory(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void confirmReservation() {
        isConfirmed = true;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOverlapping(RoomReservation roomReservation) {
        return isOverlapping(roomReservation.getRoom().getId(), roomReservation.getDate());
    }

    public boolean isOverlapping(String roomId, LocalDate date) {
        return Objects.equals(this.room.getId(), roomId) &&
                this.date.getYear() == date.getYear() &&
                this.date.getMonth() == date.getMonth() &&
                this.date.getDayOfMonth() == date.getDayOfMonth();
    }

    public String getId()
    {
        return id;
    }
}
