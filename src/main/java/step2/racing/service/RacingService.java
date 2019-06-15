package step2.racing.service;

import step2.racing.model.Car;
import step2.racing.random.RealRandomGenerator;
import step2.racing.ui.InputView;
import step2.racing.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {

    private int raceCount = 0;

    private final InputView inputView;
    private final ResultView resultView;

    public RacingService(InputView inputView, ResultView resultView) {

        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {

        int carCount = inputView.askCarCount();
        int attempts = inputView.askAttempts();

        List<Car> cars = createCars(carCount);
        while (!isFinished(attempts)) {
            resultView.printEntireCarsPosition(cars);
            raceEntireCars(cars);
        }
    }

    private List<Car> createCars(int carCount) {

        return IntStream.range(0, carCount)
                .mapToObj(number -> Car.of(number, new RealRandomGenerator()))
                .collect(Collectors.toList());
    }

    private boolean isFinished(int attempts) {

        return raceCount >= attempts;
    }

    private void raceEntireCars(List<Car> cars) {

        cars.forEach(Car::race);
        raceCount++;
    }
}
