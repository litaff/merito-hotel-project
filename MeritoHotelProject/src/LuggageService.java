public class LuggageService extends SpecialService{
    @Override
    public void orderService() {
        System.out.println("Luggage is stored in the hotel.");
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
        this.name = "LUGGAGE/" + name;
    }
}
