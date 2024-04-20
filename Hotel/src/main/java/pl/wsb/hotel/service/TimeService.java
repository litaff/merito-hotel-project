package pl.wsb.hotel.service;

import pl.wsb.hotel.client.Client;
import pl.wsb.hotel.room.Room;

import java.time.LocalTime;

public class TimeService extends SpecialService{

    public TimeService(String name) {
        super(name);
    }

    @Override
    public void orderService() {
        System.out.println(LocalTime.now());
    }

    @Override
    public boolean isServiceAvailableFor(Client client) {
        return true;
    }

    @Override
    public void queueServiceFor(Room room) {
        roomQueue.add(room);
    }
}
