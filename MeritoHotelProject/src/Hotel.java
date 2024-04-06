public class Hotel {
    private String name;
    private SpecialService[] specialServices;
    private Client[] clients;
    private RoomReservation[] roomReservations;
    private Room[] rooms;

    public Hotel(String name)
    {
        this.name = name;
        specialServices = new SpecialService[]{};
        clients = new Client[]{};
        roomReservations = new RoomReservation[]{};
        rooms = new Room[]{};
    }
}
