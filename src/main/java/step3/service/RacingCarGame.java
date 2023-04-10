package step3.service;

import step3.domain.Car;
import step3.domain.InputCar;
import step3.util.RandomValue;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements GameStrategy {

    private static final int RANDOM_BOUND = 10;

    private final GameMatcher matcher;
    private List<Car> cars;

    public RacingCarGame(GameMatcher matcher) {
        this.matcher = matcher;
        cars = new ArrayList<>();
    }

    @Override
    public InputCar input() {
        final int carCount = InputView.inputCarCount();
        final int retry = InputView.inputRetryCount();

        return new InputCar(carCount, retry);
    }

    @Override
    public void playGame(InputCar inputCar) {
        initCarStatus(inputCar.getCount());

        for (int i = 0; i < inputCar.getRetry(); i++) {
            playRacingCar();
            printCarStatus();
        }
    }

    private void initCarStatus(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void playRacingCar() {
        for (Car car : cars) {
            checkForward(car);
        }
    }

    private void checkForward(Car car) {
        final int random = RandomValue.nextInt(RANDOM_BOUND);

        if (matcher.match(random)) {
            car.forwardCar();
        }
    }

    @Override
    public void printCarStatus() {
        OutputView.printAllCar(cars);
    }
}
