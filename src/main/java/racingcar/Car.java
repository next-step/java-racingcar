package racingcar;

public class Car implements Comparable<Car> {

    private static final int DEFAULT_START_POSITION = 0;

    private String name;
    private int position = DEFAULT_START_POSITION;

    Car(String name) {
        this.name = name;
    }

    Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public Car move() {
        return new Car(name, position + 1);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.position, position);
    }
}
