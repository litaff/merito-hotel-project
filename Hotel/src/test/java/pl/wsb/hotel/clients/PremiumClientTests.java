package pl.wsb.hotel.clients;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PremiumClientTests {
    @Test
    public void getFullName_returnsFullNameWithPrefix() {
        var client = new PremiumClient("1", "John", "Doe", LocalDate.now(), false, "business", PremiumAccountType.PREMIUM);
        var fullName = client.getFullName();
        assertEquals("[premium]John Doe", fullName);
    }

    @Test
    public void getPremiumAccountType_returnsCorrectAccountType() {
        var client = new PremiumClient("1", "John", "Doe", LocalDate.now(), false, "business", PremiumAccountType.PREMIUM);
        var accountType = client.getPremiumAccountType();
        assertEquals(PremiumAccountType.PREMIUM, accountType);
    }

    @Test
    public void setPremiumAccountType_setsCorrectAccountType() {
        var client = new PremiumClient("1", "John", "Doe", LocalDate.now(), false, "business", PremiumAccountType.PREMIUM);
        client.setPremiumAccountType(PremiumAccountType.PREMIUM_PLUS);
        var accountType = client.getPremiumAccountType();
        assertEquals(PremiumAccountType.PREMIUM_PLUS, accountType);
    }
}
