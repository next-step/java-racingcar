package record;

public class CarRecord {

    private String name;
    private int distance;

    public CarRecord(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String name() {
        return this.name;
    }

    public int distance() {
        return this.distance;
    }
}
