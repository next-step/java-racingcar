package racing.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import racing.domain.Car;
import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;
import racing.ui.ResultView;

public class Game {
    private final NumberOfCars numberOfCars;
    private final NumberOfRound numberOfRound;
    private final List<Car> cars = new LinkedList<>();

    public Game(final NumberOfCars numberOfCars, final NumberOfRound numberOfRound) {
        this.numberOfCars = numberOfCars;
        this.numberOfRound = numberOfRound;
    }

    public void start() {
        for (int i = 0; i < numberOfCars.number; i++) {
            cars.add(new Car(i));
        }

        Random random = new Random();
        for (int i = 0; i < numberOfRound.number; i++) {
            cars.forEach(car -> car.run(random.nextInt(10)));
            ResultView.print(cars);
        }
    }
}
