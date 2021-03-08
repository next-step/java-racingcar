package racing;

import java.util.List;

public class RacingData {
    private final List<Driver> drivers;
    private final int carsCount;
    private final int attemptsCount;

    public RacingData(int carsCount, int attemptsCount) {
        this(null, carsCount, attemptsCount);
    }

    public RacingData(List<Driver> drivers, int carsCount, int attemptsCount) {
        this.drivers = drivers;
        this.carsCount = carsCount;
        this.attemptsCount = attemptsCount;
    }

    public RacingData copyWith(List<Driver> drivers) {
        return new RacingData(drivers, carsCount, attemptsCount);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public int getCarsCount() {
        return carsCount;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }
}
