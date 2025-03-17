package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        this.cars = from(carNames);
    }

    private static List<Car> from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (String username : carNames.names()) {
            cars.add(new Car(new CarName(username)));
        }
        return cars;
    }

    public void race(NumberGenerator numberGenerator) {
        for (Car car : this.cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Integer> positions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.position());
        }
        return positions;
    }

    public Map<String, Integer> positionByName() {
        return this.cars.stream()
                .collect(Collectors.toMap(Car::name, Car::position));
    }
}
