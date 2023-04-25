package racing.vehicle.factory;

import racing.vehicle.Car;
import racing.vehicle.Engine;
import racing.vehicle.RandomEngine;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {

    public static Car createRandomCar() {
        Engine randomEngine = new RandomEngine();
        return new Car(randomEngine);
    }

    public static Collection<Car> createRandomCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(i -> createRandomCar()).collect(Collectors.toList());
    }
}
