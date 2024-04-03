import java.time.*;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean isUnderAged;
    private boolean needsAccessibilityFeature;
    private String travelPurpose;

    public Client(String id, String firstName, String lastName, LocalDate birthDate, boolean needsAccessibilityFeature, String travelPurpose)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        isUnderAged = getAge() < 18;
        this.needsAccessibilityFeature = needsAccessibilityFeature;
        this.travelPurpose = travelPurpose;
    }

    public int getAge()
    {
        // Get seconds since birth in unix time
        var secondsSinceBirth = LocalDate.now().toEpochSecond(LocalTime.of(0,0,0), ZoneOffset.UTC) -
                birthDate.toEpochSecond(LocalTime.of(0,0,0), ZoneOffset.UTC);

        // Convert unix time to local date
        Instant instant = Instant.ofEpochSecond(secondsSinceBirth);
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        // Subtract unix year to leave age
        return localDate.getYear() - 1970;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }
}
