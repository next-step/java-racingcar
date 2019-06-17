package carRacing;

public class Car {

    private Engine engine;
    private int movement;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car move() {
        int output = engine.getPowerOutput();
        movement += (output < 4) ? 0 : 1;
        return this;
    }

    public int getMovement() {
        return movement;
    }
}
