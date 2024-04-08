import java.time.LocalDate;

public class RoomReservation {
    private LocalDate date;
    private boolean isConfirmed; // Confirmation has no dedicated setter, as, once confirmed, the reservation should either stay of be removed, if it was cancelled
    private Client client; // Client has no setter, as the reservation should be deleted when client is to be changed.
    private Room room;

    public RoomReservation(LocalDate date, Client client, Room room) {
        this.date = date;
        this.client = client;
        this.room = room;
        isConfirmed = false;
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
}
