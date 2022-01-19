package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;

public class Participants {
    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants getInstance(List<Car> cars) {
        return new Participants(cars);
    }

    public List<Car> getParticipants() {
        return this.cars;
    }
}
