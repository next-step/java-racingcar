package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> cars;
    private MoveChecker moveChecker;

    public Cars(final List<Car> cars, MoveChecker moveChecker) {
        this.cars = cars;
        this.moveChecker = moveChecker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars) && moveChecker.equals(cars1.moveChecker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, moveChecker);
    }

    public void doRound() {
        for (Car car : cars) {
            car.play(moveChecker);
        }
    }

    public ResultRound getRound() {
        List<ResultCar> resultCars = new ArrayList<>();
        for (Car car : cars) {
            ResultCar resultCar = car.getResult();
            resultCars.add(resultCar);
        }
        return new ResultRound(resultCars);
    }

    public ResultWinners getWinners() {
        List<String> winners = new ArrayList<>();
        int maxLocation = getMaxLocation();

        for (Car car : cars) {
            car.addCarNameIfEqualLocation(winners, maxLocation);
        }
        return new ResultWinners(winners);
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.getMaxLocation(maxLocation);
        }
        return maxLocation;
    }
}
