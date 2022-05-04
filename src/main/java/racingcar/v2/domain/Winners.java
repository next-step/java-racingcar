package racingcar.v2.domain;

import racingcar.v2.domain.car.Car;
import racingcar.v2.domain.car.Position;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<Car> findWinner(List<Car> cars) {
        Position maxPosition = maxPosition(cars);

        return addWinners(cars, maxPosition);
    }

    private static Position maxPosition(List<Car> cars) {
        Position maxPosition = new Position();

        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }

        return maxPosition;
    }

    private static List<Car> addWinners(List<Car> cars, Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }
}
