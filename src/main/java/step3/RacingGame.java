package step3;

import step3.car.Car;
import step3.view.result.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int GAME_COUNT_LOWER_BOUND = 0;

    private int remainGameCount;
    private final List<Car> cars;

    public RacingGame(int remainGameCount, int carCount) {
        this.remainGameCount = remainGameCount;
        this.cars = generateCar(carCount);
        ResultView resultView = new ResultView();
        resultView.printTitle();
    }

    public void race(int gameCount) {
        for (int i = 1; i <= gameCount; i++) {
            remainGameCount--;
            validateRemainGameCount();
            tryMoveCars();
            checkProgressOfRacing();
        }
    }

    private void validateRemainGameCount() {
        if (remainGameCount < GAME_COUNT_LOWER_BOUND)
            throw new IllegalStateException("remainGameCount is over");
    }

    private void checkProgressOfRacing() {
        ResultView resultView = new ResultView();
        resultView.printRacingResult(cars);
    }

    private void tryMoveCars() {
        for (int i = 0; i < cars.size(); i++) {
            int randomValue = RandomValueGenerator.generate();
            Car car = cars.get(i);
            car.tryMove(randomValue);
        }
    }

    private List<Car> generateCar(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
