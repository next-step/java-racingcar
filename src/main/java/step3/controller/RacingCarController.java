package step3.controller;

import step3.domain.Car;
import step3.strategy.MovingStrategy;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private List<Car> cars = new ArrayList<>();
    private final MovingStrategy strategy;

    public RacingCarController(MovingStrategy strategy) {
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
