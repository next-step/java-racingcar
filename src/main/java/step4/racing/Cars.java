package step4.racing;

import java.util.List;
import java.util.stream.Collectors;
import racing.Car;
import utils.RandomUtils;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> winners() {
        int maxPosition = maxPosition();
        return cars.stream()
            .filter(car -> car.currentPosition() == maxPosition)
            .map(Car::name)
            .collect(Collectors.toList());
    }

    public String[] carNames() {
        return cars.stream()
            .map(Car::name)
            .toArray(String[]::new);
    }

    private int maxPosition() {
        return cars.stream()
            .mapToInt(Car::currentPosition)
            .max()
            .orElseThrow(IllegalStateException::new);
    }

    public void rollTheDice(RandomUtils randomUtils, int maxRandomNumber) {
        for (Car car : cars) {
            int diceResult = randomUtils.getRandomNumber(maxRandomNumber);
            car.move(diceResult);
        }
    }

    public List<Car> cars() {
        return cars;
    }

}
