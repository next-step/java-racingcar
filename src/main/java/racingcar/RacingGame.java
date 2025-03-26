package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private final InputView inputView;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator;
    private List<Car> cars;

    public RacingGame(InputView inputView, ResultView resultView, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        inputView.initGameInput();
        initializeCars(inputView.getCarNames());
        runRace(inputView.getAttemptCount());
        resultView.printWinners(getWinners(cars));
    }

    public List<Car> runRace(int attemptCount) {
        resultView.printResultHeader();
        resultView.printResults(cars);

        for (int i = 0; i < attemptCount; i++) {
            moveCars();
            resultView.printResults(cars);
        }
        return cars;
    }

    public void initializeCars(String[] carNames) {
        cars = Arrays.stream(carNames).peek(this::validateCarNameLength).map(Car::new).collect(Collectors.toList());
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("Car name is too long");
        }
    }

    public void moveCars() {
        cars.forEach(car -> car.move(randomNumberGenerator.generate(RANDOM_NUMBER_BOUNDARY)));
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(1);

        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
