package step4.model;

public class Car {

    private int currentStatus;
    private final Name name;

    public Car(Name name) {
        this.name = name;
    }

    public Car(Name name, int currentStatus) {
        this.name = name;
        this.currentStatus = currentStatus;
    }

    public void go() {
        this.currentStatus++;
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public Name getName() {
        return this.name;
    }
}
