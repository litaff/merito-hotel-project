package pl.wsb.hotel;

import pl.wsb.hotel.client.Client;
import pl.wsb.hotel.room.Room;
import pl.wsb.hotel.room.RoomReservation;
import pl.wsb.hotel.service.SpecialService;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<SpecialService> specialServices;
    private ArrayList<Client> clients;
    private ArrayList<RoomReservation> reservations;
    private ArrayList<Room> rooms;

    public Hotel(String name)
    {
        this.name = name;
        specialServices = new ArrayList<>();
        clients = new ArrayList<>();
        reservations = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addService(SpecialService service){
        if(specialServices.contains(service)) return;
        specialServices.add(service);
    }

    public void removeService(SpecialService service){
        specialServices.remove(service);
    }

    public SpecialService getSpecialService(int index){
        if(index >= specialServices.size()) return null;
        return specialServices.get(index);
    }

    public void addClient(Client client){
        if(clients.contains(client)) return;
        clients.add(client);
    }

    public void removeClient(Client client){
        clients.remove(client);
    }

    public Client getClient(int index){
        if(index >= clients.size()) return null;
        return clients.get(index);
    }

    public void addReservation(RoomReservation reservation){
        if(reservations.contains(reservation)) return;
        reservations.add(reservation);
    }

    public void removeReservation(RoomReservation reservation){
        reservations.remove(reservation);
    }

    public RoomReservation getReservation(int index){
        if(index >= reservations.size()) return null;
        return reservations.get(index);
    }

    public void addRoom(Room room){
        if(rooms.contains(room)) return;
        rooms.add(room);
    }

    public void removeRoom(Room room){
        rooms.remove(room);
    }

    public Room getRoom(int index){
        if(index >= rooms.size()) return null;
        return rooms.get(index);
    }
}
