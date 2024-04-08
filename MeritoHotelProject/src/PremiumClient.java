import java.time.LocalDate;

public class PremiumClient extends Client{
    private PremiumAccountType premiumAccountType;

    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate,
                         boolean needsAccessibilityFeature, String travelPurpose, PremiumAccountType premiumAccountType) {
        super(id, firstName, lastName, birthDate, needsAccessibilityFeature, travelPurpose);
        this.premiumAccountType = premiumAccountType;
    }

    @Override
    public String getFullName() {
        return "[premium]" + super.getFullName();
    }

    public PremiumAccountType getPremiumAccountType() {
        return premiumAccountType;
    }

    public void setPremiumAccountType(PremiumAccountType premiumAccountType) {
        this.premiumAccountType = premiumAccountType;
    }
}
