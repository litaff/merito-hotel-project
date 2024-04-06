import java.time.LocalTime;

public class TimeService extends SpecialService{
    @Override
    public void orderService() {
        System.out.println(LocalTime.now());
    }

    @Override
    public String getName() {
        var splitName = name.split("/");
        if(splitName.length == 2)
        {
            return splitName[1];
        }
        else
        {
            return "INVALID_SERVICE";
        }
    }

    @Override
    public void setName(String name) {
        this.name = "TIME/" + name;
    }
}
