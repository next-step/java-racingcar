package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;
    private List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(InputView inputView, ResultView resultView, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        inputView.initGameInput();
        initializeCars(inputView.getNumberOfCars());
        runRace(inputView.getAttemptCount());
        resultView.printResult();
    }

    public List<Car> runRace(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            moveCars();
            resultView.saveResults(cars);
        }
        return cars;
    }

    public void initializeCars(int numberOfCars) {
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars() {
        cars.forEach(car -> car.move(randomNumberGenerator.generate(10)));
    }
}
