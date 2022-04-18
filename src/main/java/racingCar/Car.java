package racingCar;

public class Car {
    int distance = 0;

    public void tryMove() {
        if (canMoveForward(getRandomValue())) {
            distance++;
        }
    }

    public boolean canMoveForward(int number) {
        return number >= 4;
    }

    private int getRandomValue() {
        return RandomInteger.next();
    }

    public int getDistance() {
        return distance;
    }
}
