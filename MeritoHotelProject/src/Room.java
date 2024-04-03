public class Room {
    private String id;
    private String description;
    private double area;
    private int floor;
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
}
