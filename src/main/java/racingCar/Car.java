package racingCar;

public class Car {
    private int distance = 0;
    private IntegerGeneratorStrategy strategy;

    Car(IntegerGeneratorStrategy strategy) {
        this.strategy = strategy;
    }

    public void tryMove() {
        if (canMoveForward(strategy.generate())) {
            moveForward();
        }
    }

    private boolean canMoveForward(int number) {
        return number >= 4;
    }

    private void moveForward() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
