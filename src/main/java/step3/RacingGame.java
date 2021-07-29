package step3;

import step3.car.Car;
import step3.view.result.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final int tryCount;
    private final List<Car> cars;
    private final Random random = new Random();

    public RacingGame(int tryCount, int carCount) {
        this.tryCount = tryCount;
        this.cars = generateCar(carCount);
    }

    public void start() {
        ResultView resultView = new ResultView();
        resultView.printTitle();
        for (int i = 0; i < tryCount; i++) {
            tryMoveCars();
            resultView.printMoveResult(cars);
        }
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
