package racingcar.domain.car;

public class Car {
    private String name;
    private int status;
    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public int getStatus() {
        return this.status;
    }

    public void go() {
        this.status += 1;
    }
}
