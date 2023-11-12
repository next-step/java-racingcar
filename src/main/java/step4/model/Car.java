package step4.model;

public class Car {

    private int currentStatus;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int currentStatus) {
        this.name = name;
        this.currentStatus = currentStatus;
    }

    public void go() {
        this.currentStatus++;
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public String getName() {
        return this.name;
    }
}
