import java.time.LocalDate;

public class PremiumClient extends Client{
    private PremiumAccountType premiumAccountType;

    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, boolean needsAccessibilityFeature, String travelPurpose) {
        super(id, firstName, lastName, birthDate, needsAccessibilityFeature, travelPurpose);
    }

    @Override
    public String getFullName()
    {
        return "[premium]" + super.getFullName();
    }
}
