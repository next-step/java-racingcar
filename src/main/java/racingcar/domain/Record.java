package racingcar.domain;

public class Record {
    private final String name;
    private final Distance distance;

    public Record(String name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getName() {
        return name;
    }
}
