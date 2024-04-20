package pl.wsb.hotel.client;

import java.time.*;

public class Client {
    private String id; // ID should not change once set.
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

    public String getTravelPurpose() {
        return travelPurpose;
    }

    public void setTravelPurpose(String travelPurpose) {
        this.travelPurpose = travelPurpose;
    }

    public boolean isNeedsAccessibilityFeature() {
        return needsAccessibilityFeature;
    }

    public void setNeedsAccessibilityFeature(boolean needsAccessibilityFeature) {
        this.needsAccessibilityFeature = needsAccessibilityFeature;
    }

    public boolean isUnderAged() {
        return isUnderAged;
    }

    public void setUnderAged(boolean underAged) {
        isUnderAged = underAged;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }
}
