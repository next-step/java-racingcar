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
}
