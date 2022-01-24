package racingcar.domain.car;

public class Car implements Comparable<Car> {

    private final String name;
    private int status;

    private Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public void go() {
        this.status += 1;
    }

    public int compareTo(Car o) {
        return o.status - status;
    }

    public boolean compareStatus(Car o) {
        return status == o.status;
    }
}
