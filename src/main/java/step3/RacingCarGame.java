package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements GameStrategy {

    private final GameMatcher matcher;
    private List<Car> cars;

    public RacingCarGame(GameMatcher matcher) {
        this.matcher = matcher;
        cars = new ArrayList<>();
    }

    @Override
    public int inputCar() {
        return InputView.inputCarCount();
    }

    @Override
    public int inputRetry() {
        return InputView.inputRetryCount();
    }

    @Override
    public void playGame(int carCount, int retry) {
        initCarStatus(carCount);

        for (int i = 0; i < retry; i++) {
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
        if (matcher.matcher()) {
            car.forwardCar();
        }
    }

    @Override
    public void printCarStatus() {
        OutputView.printAllCar(cars);
    }
}
