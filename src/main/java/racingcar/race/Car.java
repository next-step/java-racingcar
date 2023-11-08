package racingcar.race;

public class Car {

    private static int sequence = 0;

    private final int id;
    private int distance;

    public Car() {
        id = newSequence();
        distance = 0;
    }

    private int newSequence() {
        return ++sequence;
    }

    public int id() {
        return id;
    }

    public int distance() {
        return distance;
    }

    public void move() {
        ++distance;
    }
}
