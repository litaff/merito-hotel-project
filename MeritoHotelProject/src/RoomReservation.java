import java.time.LocalDate;

public class RoomReservation {
    private LocalDate date;
    private boolean isConfirmed;
    private Client client;
    private Room room;

    public RoomReservation(LocalDate date, Client client, Room room)
    {
        this.date = date;
        this.client = client;
        this.room = room;
        isConfirmed = false;
    }

    public void confirmReservation()
    {
        isConfirmed = true;
    }
}
