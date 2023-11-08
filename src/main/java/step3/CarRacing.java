package step3;

import step3.util.InputView;
import step3.util.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();
    private final MovingStrategy strategy;

    public CarRacing(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startGame() {
        int carCount = InputView.inputCarCount();
        int attemptCount = InputView.inputAttemptCount();

        makeCars(carCount);
        ResultView.showComment("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            race();
        }
    }

    public void makeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        for (Car car : cars) {
            car.move(strategy);
            ResultView.showResult(car.getDistance());
        }
    }
}
