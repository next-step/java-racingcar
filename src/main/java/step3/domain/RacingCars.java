package step3.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
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
