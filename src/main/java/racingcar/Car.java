package racingcar;


public class Car implements Comparable<Car> {
    private static int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        position = START_POSITION;
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