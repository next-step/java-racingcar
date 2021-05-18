package racing.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int movingRange;
    static final int MOVE_COUNT = 1;

    public Car(String name, int movingRange) {
        this.name = name;
        this.movingRange = movingRange;
    }

    public Car(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getMovingRange() {
        return movingRange;
    }

    public Car moved() {
        return new Car(name, movingRange + MOVE_COUNT);
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.movingRange, movingRange);
    }

}
