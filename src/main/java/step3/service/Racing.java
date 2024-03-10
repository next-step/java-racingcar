package step3.service;

public class Racing {
    private final CarsDto cars;
    private final int tryCount;

    public static Racing of(CarsDto cars, int tryCount) {
        return new Racing(cars, tryCount);
    }

    private Racing(CarsDto cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }
}
