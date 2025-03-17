package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.ui.ResultView;

public class Race {
    private final Cars cars;
    private final int totalAttempts;

    public Race(Cars cars, int totalAttempts) {
        this.cars = cars;
        this.totalAttempts = totalAttempts;
    }

    public void start(MovingStrategy strategy) {
        System.out.println("실행 결과");
        ResultView.viewRacingCar(cars.getCurrentStatus());
        for (int attempt = 1; attempt < totalAttempts; attempt++) {
            cars.moveAll(strategy);
            ResultView.viewRacingCar(cars.getCurrentStatus());
        }
    }
}