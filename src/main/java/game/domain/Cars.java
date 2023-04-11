package game.domain;

import game.util.NumberGenerator;
import game.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> generatedCars;

    private Cars(List<Car> generatedCars) {
        this.generatedCars = generatedCars;
    }

    public static Cars generate(int count) {
        return new Cars(generateCar(count));
    }

    private static List<Car> generateCar(int carCount) {
        NumberGenerator generator = new RandomNumberGenerator();
        return IntStream.range(0, carCount)
                .mapToObj(n -> new Car(generator))
                .collect(Collectors.toUnmodifiableList());
    }

    public void drive() {
        generatedCars.forEach(Car::drive);
    }

    public List<Integer> carPositions() {
        return generatedCars.stream()
                .map(Car::position)
                .collect(Collectors.toUnmodifiableList());
    }
}