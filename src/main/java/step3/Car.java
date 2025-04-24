package step3;


public class Car {
    public static final int MOVE_CONDITION_THRESHOLD = 4;

    private Position position;

    public Car() {
        this.position = new Position();
    }

    public Position move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVE_CONDITION_THRESHOLD) {
            position = position.moveForward();
        }

        return position;
    }
}