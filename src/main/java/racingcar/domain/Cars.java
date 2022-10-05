package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        return cars.stream()
            .filter(car -> car.isDraw(representativeWinner))
            .map(car -> new CarStat(car.getName(), car.getPosition()))
            .collect(toList());
    }

    private Car findRepresentativeWinner() {
        return cars.stream()
            .reduce(this::getWinner)
            .orElseThrow();
    }

    private Car getWinner(Car car1, Car car2) {
        if (car1.isWinner(car2)) {
            return car1;
        }
        return car2;
    }
}
