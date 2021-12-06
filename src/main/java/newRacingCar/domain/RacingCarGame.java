package newRacingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {

    private Cars cars;
    private int tryTimes;

    public RacingCarGame(String[] carNames, int tryTimes) {
        if (tryTimes < 0) {
            throw new IllegalArgumentException("올바른 수를 입력하세요.");
        }
        this.cars = setPlayCars(carNames);
        this.tryTimes = tryTimes;
    }

    public int getTryTimes() {
        return this.tryTimes;
    }

    private Cars setPlayCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(new Name(name)));
        }
        return new Cars(carList);
    }

    public List<Car> move(MoveStrategy moveStrategy) {
        return cars.move(moveStrategy);
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarGame that = (RacingCarGame) o;
        return tryTimes == that.tryTimes && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryTimes);
    }
}
