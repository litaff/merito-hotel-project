public class LuggageService extends SpecialService{

    public LuggageService(String name) {
        super(name);
    }

    @Override
    public void orderService() {
        System.out.println("Luggage is stored in the hotel.");
    }

    @Override
    public boolean isServiceAvailableFor(Client client) {
        return client.getClass() == PremiumClient.class;
    }

    @Override
    public void queueServiceFor(Room room) {
        roomQueue.add(room);
    }
}
