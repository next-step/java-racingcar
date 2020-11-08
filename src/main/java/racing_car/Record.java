package racing_car;

public class Record {
    private final String name;
    private final Integer location;

    public Record(String name, Integer location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public Integer getLocation() {
        return this.location;
    }
}
