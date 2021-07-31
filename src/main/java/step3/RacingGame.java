package step3;

import step3.car.Car;
import step3.view.result.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int GAME_COUNT_LOWER_BOUND = 0;
    private static final int RANDOM_VALUE_UPPER_BOUND = 10;

    private int remainGameCount;
    private final List<Car> cars;

    public RacingGame(int remainGameCount, int carCount) {
        this.remainGameCount = remainGameCount;
        this.cars = generateCar(carCount);
        ResultView resultView = new ResultView();
        resultView.printTitle();
    }

    public void race() {
        remainGameCount--;
        validateRemainGameCount();
        tryMoveCars();
        checkProgressOfRacing();
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
        Random random = new Random();
        for (int i = 0; i < cars.size(); i++) {
            int randomValue = random.nextInt(RANDOM_VALUE_UPPER_BOUND);
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
