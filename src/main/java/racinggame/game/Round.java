package racinggame.game;

import racinggame.car.Car;
import racinggame.car.Position;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Round {

    private final Map<Car, Position> result;

    public Round(List<Car> cars) {
        this.result = cars.stream()
                .collect(Collectors.toMap(
                        car -> car,
                        Car::position
                ));
    }

    public Map<Car, Position> result() {
        return this.result;
    }
}
