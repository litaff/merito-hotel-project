package pl.wsb.hotel.services;

import org.junit.jupiter.api.Test;
import pl.wsb.hotel.clients.Client;
import pl.wsb.hotel.clients.PremiumAccountType;
import pl.wsb.hotel.clients.PremiumClient;
import pl.wsb.hotel.rooms.Room;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LuggageServiceTests {
    @Test
    public void isServiceAvailableFor_returnsTrueForPremiumClient() {
        LuggageService luggageService = new LuggageService("Luggage");
        var client = new PremiumClient("1", "John", "Doe", LocalDate.now(), false, "business", PremiumAccountType.PREMIUM);
        assertTrue(luggageService.isServiceAvailableFor(client));
    }

    @Test
    public void isServiceAvailableFor_returnsFalseForRegularClient() {
        LuggageService luggageService = new LuggageService("Luggage");
        var client = new Client("1", "John", "Doe", LocalDate.now(), false, "business");
        assertFalse(luggageService.isServiceAvailableFor(client));
    }

    @Test
    public void queueServiceFor_addsRoomToQueue() {
        LuggageService luggageService = new LuggageService("Luggage");
        var room = new Room("1", "1", 1, 1, false);
        luggageService.queueServiceFor(room);
        assertEquals(1, luggageService.roomQueue.size());
    }
}
