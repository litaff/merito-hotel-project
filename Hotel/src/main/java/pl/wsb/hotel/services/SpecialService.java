package pl.wsb.hotel.services;

import pl.wsb.hotel.clients.Client;
import pl.wsb.hotel.rooms.Room;

import java.util.ArrayList;

public abstract class SpecialService {
    protected String name;
    protected ArrayList<Room> roomQueue;

    public SpecialService(String name){
        this.name = name;
        roomQueue = new ArrayList<>();
    }

    public abstract void orderService();

    public abstract boolean isServiceAvailableFor(Client client);

    public abstract void queueServiceFor(Room room);

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
