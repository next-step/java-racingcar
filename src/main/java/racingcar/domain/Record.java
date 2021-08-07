package racingcar.domain;

public class Record {
    private final Name name;
    private final Distance distance;

    public Record(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public Name getName() {
        return name;
    }
}
