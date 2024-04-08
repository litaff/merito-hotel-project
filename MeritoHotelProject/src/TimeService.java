import java.time.LocalTime;

public class TimeService extends SpecialService{

    public TimeService(String name) {
        super(name);
    }

    @Override
    public void orderService() {
        System.out.println(LocalTime.now());
    }

    @Override
    public boolean isServiceAvailableFor(Client client) {
        return true;
    }

    @Override
    public void queueServiceFor(Room room) {
        roomQueue.add(room);
    }
}
