package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
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
