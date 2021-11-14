package carracingwinner.domain;

import carracingwinner.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public Result move() {
        cars.forEach(car -> car.move(RandomUtils.randomInt()));
        return new Result(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getLastWinners() {
        int max = cars.stream()
                .mapToInt(car -> car.getPosition().getIntValue())
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition().getIntValue() == max)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

}
