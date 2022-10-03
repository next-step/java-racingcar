package racingcar.domain;

public class Racing {
    private static final int MIN_CAR_COUNT = 1;
    private static final int MIN_TRY_COUNT = 1;
    
    private final Cars cars;
    private final int tryCount;

    private Racing(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void race(Watcher watcher) {
        Distances distances = new Distances();
        for (int count = 0; count < tryCount; count++) {
            distances = cars.move();
            watcher.notify(distances);
        }
        watcher.notifyFinish(distances);
    }
    
    public static Racing of(CarNames names, int tryCount) {
        if (names.carCount() < MIN_CAR_COUNT || tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("Number of cars is greater than 0 and trial count must be greater than or equal to 1.");
        }
        return racing(names, tryCount);
    }

    private static Racing racing(CarNames names, int tryCount) {
        return new Racing(names.createCars(), tryCount);
    }
}
