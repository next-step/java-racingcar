package racing.domain;

import racing.domain.factory.CarsFactory;

import java.util.Objects;

public class RacingGame {
    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = CarsFactory.newInstance(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    public void race() {
        cars.moveCars();
        tryCount.increaseCount();
    }

    public String getCarsStatus() {
        return cars.toString();
    }

    public Cars getWinnerCars() {
        return cars.getWinnerCars();
    }

    public boolean isRacing() {
        return !tryCount.isDone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return tryCount == that.tryCount && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryCount);
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", tryCount=" + tryCount +
                '}';
    }
}
