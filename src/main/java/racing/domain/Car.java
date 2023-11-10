package racing.domain;

public class Car {
    private int distance;
    private static final int CONDITION_FOR_MOVE = 4;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveCar() {
        this.distance++;
    }

    public void validateForMove(int randomValue) {
        if (isMovable(randomValue)) {
            this.moveCar();
        }
    }

    private static boolean isMovable(int randomValue) {
        return randomValue >= CONDITION_FOR_MOVE;
    }
}
