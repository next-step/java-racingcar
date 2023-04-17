package racingcar.domain;

import racingcar.controller.CarController;
import racingcar.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private final int numberOfCars;
    private final int numberOfRaces;

    public Racing(int numberOfCars, int numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
    }

    public void excute(NumberGenerator numberGenerator) {
        List<Car> cars = getCars();

        IntStream.range(0, numberOfRaces).forEach(i -> {
            IntStream.range(0, numberOfCars)
                    .forEach(j -> CarController.move(cars.get(j), numberGenerator));
            System.out.println("");
        });
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();

        IntStream.range(0, numberOfCars)
                .forEach(i -> cars.add(new Car()));
        return cars;
    }
}
