package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.MovingStrategy;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {

    private final List<Car> cars;
    private final int numberOfOperations;
    private final MovingStrategy movingStrategy;
    private final Random numberGenerator;
    private final OutputView outputView;

    public RacingCarController(int numberOfParticipants, int numberOfOperations, OutputView outputView) {
        this.cars = IntStream.range(0, numberOfParticipants)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        this.numberOfOperations = numberOfOperations;
        this.movingStrategy = new MovingStrategy();
        this.numberGenerator = new Random();
        this.outputView = outputView;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getOperationCount() {
        return numberOfOperations;
    }

    public void run() {
        outputView.printStartMessage();
        for (int i = 0; i < numberOfOperations; i++) {
            tryOneRace();
            outputView.printResult(getResults());
        }
    }

    private List<Integer> getResults() {
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
