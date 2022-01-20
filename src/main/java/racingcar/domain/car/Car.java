package racingcar.domain.car;

public class Car implements Comparable<Car>{
    private String name;
    private int status;
    private Car(String name) {
        this.name = name;
        this.status = 0;
    }

    private Car(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public static Car of(String name, int status) {
        return new Car(name, status);
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public Car go() {
        return Car.of(this.name, this.status + 1);
    }

    public int compareTo(Car o) {
        return o.status - status;
    }

    public boolean compareStatus(Car o) {
        return status == o.status;
    }
}
