package pl.wsb.hotel.services;

import org.junit.jupiter.api.Test;
import pl.wsb.hotel.rooms.Room;

public class TimeServiceTests {
    @Test
    public void isServiceAvailableFor_returnsTrue() {
        var timeService = new TimeService("Time service");
        var isAvailable = timeService.isServiceAvailableFor(null);
        assert isAvailable;
    }

    @Test
    public void queueServiceFor_addsRoomToQueue() {
        var timeService = new TimeService("Time service");
        var room = new Room("1", "1", 1, 1, false);
        timeService.queueServiceFor(room);
        assert timeService.roomQueue.contains(room);
    }
}
