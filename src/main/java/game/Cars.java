package game;

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
        return IntStream.range(0, carCount)
                .mapToObj(n -> new Car())
                .collect(Collectors.toUnmodifiableList());
    }

    public void drive() {
        generatedCars.parallelStream()
                .forEach(Car::drive);
    }

    public int count() {
        return generatedCars.size();
    }

    public int racingCount() {
        return generatedCars.get(0).moveCount();
    }
}