package step3.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars create(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public List<Car> getWinner() {
        cars.sort(Comparator.comparingInt(Car::getPosition).reversed());
        List<Car> winners = new ArrayList<>();
        int maxPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
                continue;
            }
            break;
        }
        return winners;
    }

    public List<Car> getAll() {
        return cars;
    }
}
