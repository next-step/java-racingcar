package racingcar;

public class Record {
    private final String name;
    private final Distance distance;

    public Record(String name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Distance getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
