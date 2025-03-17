package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.ui.ResultView;

public class RacingCar {

    private final Car[] cars;
    private int num;

    public RacingCar(Car[] cars, int num) {
        this.cars = cars;
        this.num = num;
    }

    public void racing(MovingStrategy movingStrategy) {
        System.out.println("실행 결과");
        ResultView.viewRacingCar(cars);

        for (int i = 1; i < num; i++) {
            for (Car car : cars) {
                car.move(movingStrategy);
            }
            ResultView.viewRacingCar(cars);
        }
    }
}
