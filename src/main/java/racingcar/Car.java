package racingcar;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

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
