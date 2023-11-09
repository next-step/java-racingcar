package step4.model;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private int currentStatus;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void go(int condition) {
        if (condition >= MOVE_CONDITION) {
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
