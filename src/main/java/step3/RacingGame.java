package step3;

import step3.car.Car;
import step3.view.result.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final int tryLimit;
    private final List<Car> cars;
    private final Random random = new Random();
    private final ResultView resultView = new ResultView();

    private int triedCount = 0;

    public RacingGame(int tryLimit, int carCount) {
        this.tryLimit = tryLimit;
        this.cars = generateCar(carCount);
    }

    public void race() {
        triedCount++;
        validateTryCount();
        tryMoveCars();
        checkProgressOfRacing();
    }

    private void validateTryCount() {
        if (tryLimit < triedCount)
            throw new IllegalStateException("tryCount is over");
    }

    private void checkProgressOfRacing() {
        if (triedCount == 1)
            resultView.printTitle();

        resultView.printRacingResult(cars);
    }

    private void tryMoveCars() {
        for (int i = 0; i < cars.size(); i++) {
            int randomValue = random.nextInt(10);
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
