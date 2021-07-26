package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void attempt() {
        RandomGenerator randomGenerator = new RandomGenerator();
        cars.forEach(car -> car.go(randomGenerator.getRandomInt()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .collect(Collectors.toList());
    }

}
