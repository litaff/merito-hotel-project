package pl.wsb.hotel.service;

import pl.wsb.hotel.client.Client;
import pl.wsb.hotel.room.Room;

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
