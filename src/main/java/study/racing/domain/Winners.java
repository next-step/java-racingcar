package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(List<Car> cars) {
        if (cars.isEmpty()) {
            return new Winners(cars);
        }
        return new Winners(findWinners(cars, findMaxPosition(cars)));
    }

    private static Car findMaxPosition(List<Car> cars) {
        Car maxPositionCar = cars.get(0);
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.isPositionGreaterThan(maxPositionCar)) {
                maxPositionCar = car;
            }
        }
        return maxPositionCar;
    }

    private static List<Car> findWinners(List<Car> cars, Car maxPositionCar) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(maxPositionCar)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        return names;
    }
}
