package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class History {

    private Round round;
    private List<Car> cars;

    public History(Round round, List<Car> cars) {
        this.round = new Round(round);
        this.cars = cars.stream()
                .map(car -> new Car(car))
                .collect(Collectors.toList());
    }

    public Round getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> topCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isTop(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.compareMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
