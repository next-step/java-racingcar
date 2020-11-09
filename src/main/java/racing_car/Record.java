package racing_car;


public class Record implements Comparable<Record> {
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

    public boolean isSameLocation(Record record) {
        return this.location.equals(record.getLocation());
    }

    @Override
    public int compareTo(Record o) {
        return this.getLocation() - o.getLocation();
    }
}
