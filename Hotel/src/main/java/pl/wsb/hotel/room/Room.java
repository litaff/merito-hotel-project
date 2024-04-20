package pl.wsb.hotel.room;

public class Room {
    private String id; // ID should not change once set
    private String description;
    private double area;
    private int floor; // Floor should not change once set
    private boolean hasKingSizeBed;
    private int maxOccupancy;
    private boolean isAvailable;
    private boolean allowsPets;

    public Room(String id, String description, double area, int floor, boolean hasKingSizeBed, int maxOccupancy, boolean allowsPets){
        this.id = id;
        this.description = description;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.maxOccupancy = maxOccupancy;
        this.allowsPets = allowsPets;
        isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isHasKingSizeBed() {
        return hasKingSizeBed;
    }

    public void setHasKingSizeBed(boolean hasKingSizeBed) {
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAllowsPets() {
        return allowsPets;
    }

    public void setAllowsPets(boolean allowsPets) {
        this.allowsPets = allowsPets;
    }
}
