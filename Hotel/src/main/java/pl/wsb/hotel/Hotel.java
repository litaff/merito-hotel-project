package pl.wsb.hotel;

import pl.wsb.hotel.clients.Client;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;
import pl.wsb.hotel.interfaces.HotelCapability;
import pl.wsb.hotel.rooms.Room;
import pl.wsb.hotel.rooms.RoomReservation;
import pl.wsb.hotel.services.SpecialService;

import java.time.LocalDate;
import java.util.*;

public class Hotel implements HotelCapability {
    private String name;
    private ArrayList<SpecialService> specialServices;
    private ArrayList<Client> clients;
    private ArrayList<RoomReservation> reservations;
    private ArrayList<Room> rooms;

    public Hotel(String name)
    {
        this.name = name;
        specialServices = new ArrayList<>();
        clients = new ArrayList<>();
        reservations = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addService(SpecialService service){
        if(specialServices.contains(service)) return;
        specialServices.add(service);
    }

    public void removeService(SpecialService service){
        specialServices.remove(service);
    }

    public SpecialService getSpecialService(int index){
        if(index >= specialServices.size()) return null;
        return specialServices.get(index);
    }

    public void removeClient(Client client){
        clients.remove(client);
    }

    public Client getClient(int index){
        if(index >= clients.size()) return null;
        return clients.get(index);
    }

    public void removeReservation(RoomReservation reservation){
        reservations.remove(reservation);
    }

    public RoomReservation getReservation(int index){
        if(index >= reservations.size()) return null;
        return reservations.get(index);
    }

    public void removeRoom(Room room){
        rooms.remove(room);
    }

    public Room getRoom(int index){
        if(index >= rooms.size()) return null;
        return rooms.get(index);
    }

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        var uuid = UUID.randomUUID().toString();
        var client = new Client(uuid, firstName, lastName, birthDate);
        return uuid;
    }

    @Override
    public String getClientFullName(String clientId) {
        for (var client : clients) {
            if(Objects.equals(client.getId(), clientId)) return client.getFullName();
        }
        return "";
    }

    @Override
    public int getNumberOfUnderageClients() {
        return (int)clients.stream().filter(Client::isUnderAged).count();
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        var uuid = UUID.randomUUID().toString();
        var room = new Room(uuid, description, area, floor, hasKingSizeBed);
        rooms.add(room);
        return uuid;
    }

    @Override
    public double getRoomArea(String roomId) {
        for (var room : rooms) {
            if(Objects.equals(room.getId(), roomId)) return room.getArea();
        }
        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        return (int)rooms.stream().filter(room -> room.getFloor() == floor && room.isHasKingSizeBed()).count();
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        var uuid = UUID.randomUUID().toString();

        Client reservationClient = null;
        for (var client : clients) {
            if(Objects.equals(client.getId(), clientId)) {
                reservationClient = client;
                break;
            }
        }
        if (reservationClient == null)
            throw new ClientNotFoundException("Could not add reservation, as specified client dose not exist!");

        Room reservationRoom = null;
        for (var room : rooms) {
            if(Objects.equals(room.getId(), roomId)) {
                reservationRoom = room;
                break;
            }
        }
        if (reservationRoom == null)
            throw new RoomNotFoundException("Could not add reservation, as specified room dose not exist!");


        var reservation = new RoomReservation(uuid, date, reservationClient, reservationRoom);

        if (reservations.stream().anyMatch(roomReservation -> roomReservation.isOverlapping(reservation)))
            throw new RoomReservedException(roomId, date);

        reservations.add(reservation);

        return uuid;
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        RoomReservation roomReservation = null;
        for (var reservation : reservations) {
            if(Objects.equals(reservation.getId(), reservationId)) {
                roomReservation = reservation;
                break;
            }
        }
        if(roomReservation == null)
            throw new ReservationNotFoundException("Could not confirm reservation, as specified room dose not exist!");

        roomReservation.confirmReservation();
        return reservationId;
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        if (rooms.stream().noneMatch(room -> Objects.equals(room.getId(), roomId)))
            throw new RoomNotFoundException("Could not add reservation, as specified room dose not exist!");

        return reservations.stream().anyMatch(reservation -> reservation.isOverlapping(roomId, date));
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        return (int)reservations.stream().filter(roomReservation -> !roomReservation.isConfirmed()).count();
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {
        Client quaryClient = null;
        for (var client : clients) {
            if(Objects.equals(client.getId(), clientId)) {
                quaryClient = client;
                break;
            }
        }
        if (quaryClient == null)
            throw new ClientNotFoundException("Could not add reservation, as specified client dose not exist!");

        ArrayList<String> roomIds = new ArrayList<>();
        for (var reservation : quaryClient.getReservationHistory()) {
            var id = reservation.getRoom().getId();
            if(roomIds.contains(id)) continue;
            roomIds.add(id);
        }

        return roomIds;
    }
}
