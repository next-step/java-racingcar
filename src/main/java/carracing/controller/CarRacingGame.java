package carracing.controller;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import carracing.domain.RandomGenerator;
import carracing.view.InputView;
import carracing.view.OutputView;

import java.util.List;

public class CarRacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        CarFactory carFactory = new CarFactory();
        startRacing(carFactory.makeCars(inputView.scanCounts()), inputView.scanTimes());
    }

    private void startRacing(List<Car> cars, int tryTimes) {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (int i = 0; i < tryTimes; i++) {
            moveTry(cars, randomGenerator);
            outputView.printBlank();
        }
    }

    private void moveTry(List<Car> cars, RandomGenerator randomGenerator) {
        for (Car car : cars) {
            car.move(randomGenerator.makeRandomValue());
            outputView.printTrail(car.getPosition());
        }
    }
}
