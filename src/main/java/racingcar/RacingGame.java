package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private static Random randomGenerator;
    private List<Car> cars;

    public RacingGame(Random randomGenerator, int numberOfCars) {
        this.randomGenerator = randomGenerator;
        generateCars(numberOfCars);
    }

    public void progress() {
        cars.forEach(car -> car.move());
    }

    public List<Car> getCars() {
        return cars;
    }

    private void generateCars(int numberOfCars) {
        cars = IntStream
                .range(0, numberOfCars)
                .mapToObj(__ -> new Car(randomGenerator))
                .collect(Collectors.toList());
    }
}
