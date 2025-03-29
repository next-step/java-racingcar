package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.MovingStrategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;
    private final Random numberGenerator;

    public RacingGame(int numberOfParticipants) {
        this.cars = IntStream.range(0, numberOfParticipants)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        this.movingStrategy = new MovingStrategy();
        this.numberGenerator = new Random();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Integer> getResults() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }

    public void tryOneRace() {
        for (Car car: cars) {
            if (movingStrategy.isMoving(numberGenerator.nextInt(10))) {
                car.move();
            }
        }
    }

}
