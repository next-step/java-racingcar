package racingcar.domain.car;

public class Car implements Comparable<Car>{
    private final String name;
    private int position;
    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void go() {
        this.position += 1;
    }

    public int compareTo(Car o) {
        return o.position - position;
    }

    public boolean compareStatus(Car o) {
        return position == o.position;
    }
}
