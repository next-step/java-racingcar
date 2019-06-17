package carRacing;

public class Car {

    private final int MOVEMENT_LIMIT_BY_OUTPUT = 4;
    private Engine engine;
    private int movement;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car move() {
        int output = engine.getPowerOutput();
        if (canMove(output)) {
            movement += 1;
        }
        return this;
    }

    private boolean canMove(int output) {
        return MOVEMENT_LIMIT_BY_OUTPUT <= output;
    }



    public int getMovement() {
        return movement;
    }
}
