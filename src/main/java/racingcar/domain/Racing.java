package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Racing {

    private final Cars cars;
    private int tryCount;

    public Racing(final String inputCars, final int tryCount, final DriveWay driveWay) {
        this.cars = new Cars(inputCars, driveWay);
        this.tryCount = tryCount;
    }

    public void race() {
        cars.race();
        tryCount--;
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

    public boolean isFinish() {
        return this.tryCount == 0;
    }

    public List<Car> getCars() {
        return this.cars.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return tryCount == racing.tryCount &&
                Objects.equals(cars, racing.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryCount);
    }
}
