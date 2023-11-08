package step4.model;

public class Car {

    private int currentStatus;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        if (Rule.isCarMovable(Rule.getRandomValue())) {
            this.currentStatus++;
        }
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public String getName() {
        return this.name;
    }
}
