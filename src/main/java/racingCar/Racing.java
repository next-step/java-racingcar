package racingCar;

public class Racing {
    private int carCount;
    private int roundCount;
    private Car[] cars;

    public final int MINIMUM_CAR_COUNT = 2;
    public final int MINIMUM_ROUND_COUNT = 1;


    public Racing (int inputCarCount, int inputRoundCount) {
        carCount = inputCarCount;
        roundCount = inputRoundCount;

        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public boolean holdPossible() {
        if (carCount < MINIMUM_CAR_COUNT || roundCount < MINIMUM_ROUND_COUNT) {
            return false;
        }
        return true;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Car[] getCars() {
        return cars;
    }
}
