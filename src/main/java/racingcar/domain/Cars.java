package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.movingcondition.MovingCondition;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarStat> move(MovingCondition movingCondition) {
        List<CarStat> result = new ArrayList<>();

        for (Car car : cars) {
            result.add(new CarStat(car.getName(), car.move(movingCondition)));
        }

        return result;
    }

    public List<CarStat> findWinners() {
        Car representativeWinner = findRepresentativeWinner();
        List<CarStat> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.hasSamePosition(representativeWinner)) {
                winners.add(new CarStat(car.getName(), car.getPosition()));
            }
        }
        return winners;
    }

    private Car findRepresentativeWinner() {
        return cars.stream()
            .max(Car::isWinner)
            .orElseThrow();
    }
}
