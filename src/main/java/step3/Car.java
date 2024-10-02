package step3;

public class Car {
    private final Position position;

    public Car() {
        this.position = Position.zeroPosition();
    }

    public void move(CarEngine carEngine) {
        if (carEngine.canGetPower()) {
            position.forwardOnce();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
}
