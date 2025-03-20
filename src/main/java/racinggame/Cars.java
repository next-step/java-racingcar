package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames, MoveStrategy moveStrategy) {
        return new Cars(CarFactory.createCars(carNames, moveStrategy));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void run(int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(1);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }

    private void moveCars() {
        cars.forEach(Car::move);
    }
}
