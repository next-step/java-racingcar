package game;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.position());
        }
        return positions;
    }
}
