package racingcar.domains;

import racingcar.strategies.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;


    public Cars() {
        cars = new ArrayList<>();
    }


    public void add(Car car) {
        cars.add(car);
    }


    public Cars move(MoveStrategy moveStrategy) {
        for (Car car: cars) {
            car.move(moveStrategy);
        }

        return this;
    }

    public String getWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return buildWinnerNames(maxPositionCar);
    }

    private String buildWinnerNames(Car maxPositionCar) {
        StringBuilder winnerNames = new StringBuilder();

        for (Car car : cars) {
            if (car.equalsPosition(maxPositionCar)) {
                winnerNames.append(car.getName());
                winnerNames.append(",");
            }
        }

        winnerNames.deleteCharAt(winnerNames.length() - 1);

        return winnerNames.toString();
    }

    private Car getMaxPositionCar() {
        Car maxPositionCar = new Car("max", 0);

        for (Car car : cars) {
            if (car.isAhead(maxPositionCar)) {
                maxPositionCar.changePosition(car);
            }
        }
        return maxPositionCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
