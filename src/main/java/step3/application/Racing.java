package step3.application;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    private final ConsoleIn consoleIn;
    private final ConsoleOut consoleOut;

    public Racing(ConsoleIn consoleIn, ConsoleOut consoleOut) {
        this.consoleIn = consoleIn;
        this.consoleOut = consoleOut;
    }

    public void init() {
        consoleOut.askCarsCount();
        int numberOfCars = consoleIn.numberOfCars();
        Cars cars = makeCars(numberOfCars);
        consoleOut.askMoveCount();
        int moveCount = consoleIn.moveCount();
        for (int i = 0; i < moveCount; i++) {
            consoleOut.result(cars, NumberGenerator.RandomNumberGenerator(10));
        }
    }

    private Cars makeCars(int numberOfCars) {
        List<Car> carList = IntStream.range(0, numberOfCars)
                .mapToObj(__ -> new Car())
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
