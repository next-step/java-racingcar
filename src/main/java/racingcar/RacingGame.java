package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private static Random randomGenerator;
    private List<Car> cars;

    public RacingGame(Random randomGenerator, int numberOfCar) {
        this.randomGenerator = randomGenerator;
        generateCars(numberOfCar);
    }

    public List<Integer> move() {
        cars.stream()
                .forEach(car -> car.move());

        return IntStream.range(0, cars.size())
                .mapToObj(i -> cars.get(i).getMoveCount())
                .collect(Collectors.toList());
    }

    private void generateCars(int numberOfCar) {
        cars = IntStream
                .range(0, numberOfCar)
                .mapToObj(__ -> new Car(randomGenerator))
                .collect(Collectors.toList());
    }
}
