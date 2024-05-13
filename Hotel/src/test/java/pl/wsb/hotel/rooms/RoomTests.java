package pl.wsb.hotel.rooms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTests {
    @Test
    public void getId_returnsId(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertEquals("1", room.getId());
    }

    @Test
    public void getDescription_returnsDescription(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertEquals("description", room.getDescription());
    }

    @Test
    public void setDescription_setsDescription(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        room.setDescription("new description");
        assertEquals("new description", room.getDescription());
    }

    @Test
    public void getArea_returnsArea(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertEquals(20, room.getArea());
    }

    @Test
    public void setArea_setsArea(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        room.setArea(30);
        assertEquals(30, room.getArea());
    }

    @Test
    public void getFloor_returnsFloor(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertEquals(1, room.getFloor());
    }

    @Test
    public void isHasKingSizeBed_returnsHasKingSizeBed(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertTrue(room.isHasKingSizeBed());
    }

    @Test
    public void setHasKingSizeBed_setsHasKingSizeBed(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        room.setHasKingSizeBed(false);
        assertFalse(room.isHasKingSizeBed());
    }

    @Test
    public void getMaxOccupancy_returnsMaxOccupancy(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertEquals(2, room.getMaxOccupancy());
    }

    @Test
    public void isAvailable_returnsIsAvailable(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertTrue(room.isAvailable());
    }

    @Test
    public void setAvailable_setsIsAvailable(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        room.setAvailable(false);
        assertFalse(room.isAvailable());
    }

    @Test
    public void isAllowsPets_returnsAllowsPets(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        assertTrue(room.isAllowsPets());
    }

    @Test
    public void setAllowsPets_setsAllowsPets(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        room.setAllowsPets(false);
        assertFalse(room.isAllowsPets());
    }

    @Test
    public void setMaxOccupancy_setsMaxOccupancy(){
        Room room = new Room("1", "description", 20, 1, true, 2, true);
        room.setMaxOccupancy(3);
        assertEquals(3, room.getMaxOccupancy());
    }
}
