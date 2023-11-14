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
            car.move(RandomPicker.getRandomNumberInRange(car.getRandomRange()));
        }
    }

    public List<Car> getWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return cars.stream().filter(car -> car.isMaxPosition(maxPositionCar)).collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        Car maxPositionCar = cars.get(0);

        for (Car car : cars) {
            maxPositionCar = car.getMaxPositionCar(maxPositionCar);
        }

        return maxPositionCar;
    }
}
