package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ParticipateCars {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private List<Car> cars;

    public ParticipateCars(int numberOfCar) {
        this.cars = createCars(numberOfCar);
    }

    private List<Car> createCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<Integer> tryMove(Random random) {
        return this.cars.stream()
                .map(car -> car.move(random.nextInt(RANDOM_NUMBER_BOUND)))
                .collect(Collectors.toList());
    }
}
