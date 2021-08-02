package racingCar.model;

import java.util.*;

public class RacingGame {

    private final Cars cars;
    private final int playCount;

    public RacingGame(String[] carNames, final int playCount) {
        this.cars = makeCars(carNames);
        this.playCount = playCount;
    }

    public RacingGame(Cars cars, final int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    private Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> moveCars(MovingStrategy movingStrategy) {
        return cars.move(movingStrategy);
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

    public int getPlayCount() {
        return playCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return playCount == that.playCount &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, playCount);
    }
}
