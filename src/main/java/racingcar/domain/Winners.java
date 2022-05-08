package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(Cars cars) {
        winners = findWinners(cars.getCars());
    }

    private List<Car> findWinners(List<Car> carList) {
        Position maxPosition = maxPosition(carList);

        return addWinners(carList, maxPosition);
    }

    private Position maxPosition(List<Car> cars) {
        Position maxPosition = new Position();

        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }

        return maxPosition;
    }

    private List<Car> addWinners(List<Car> cars, Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    public int getLastIndex() {
        return winners.size() - 1;
    }
}
