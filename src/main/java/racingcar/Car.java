package racingcar;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        position = 0;
        this.name = name;

    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}