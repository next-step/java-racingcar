package racingcar.domain;

public class CarRecord{
    private final String name;
    private final int distance;

    public CarRecord(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
