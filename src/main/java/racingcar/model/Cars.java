package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(RandomPicker.getRandomNumberInRange(9));
        }
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }

    private int findMaxPosition() {
        Car maxPositionCar = cars.get(0);

        for (Car car : cars) {
            if (car.getPosition() > maxPositionCar.getPosition()) {
                maxPositionCar = car;
            }
        }

        return maxPositionCar.getPosition();
    }
}
