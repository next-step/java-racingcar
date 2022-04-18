package racing.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import racing.domain.Car;
import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;
import racing.ui.ResultView;

public class Game {
    private static final int RANDOM_BOUND_UNDER = 10;

    private final NumberOfCars numberOfCars;
    private final NumberOfRound numberOfRound;
    private final List<Car> cars = new LinkedList<>();
    private final Random random = new Random();

    public Game(final NumberOfCars numberOfCars, final NumberOfRound numberOfRound) {
        this.numberOfCars = numberOfCars;
        this.numberOfRound = numberOfRound;
    }

    public void start() {
        equipRacingCar();

        for (int i = 0; i < numberOfRound.number; i++) {
            proceedRound();
            ResultView.print(cars);
        }
    }

    private void equipRacingCar() {
        for (int i = 0; i < numberOfCars.number; i++) {
            cars.add(new Car());
        }
    }

    private void proceedRound() {
        cars.forEach(car -> car.run(random.nextInt(RANDOM_BOUND_UNDER)));
    }
}
