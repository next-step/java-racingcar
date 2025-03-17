package utils;

import car.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGenerator {
    public static List<Car> generateCars(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }
}
