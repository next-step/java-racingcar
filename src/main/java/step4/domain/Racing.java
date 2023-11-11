package step4.domain;

import step4.helper.NumberUtil;
import step4.view.ResultView;

import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int round;

    public Racing(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.round; i++) {
            startRound();
            ResultView.print(cars);
        }
    }

    private void startRound() {
        for (Car car : cars) {
            car.move(NumberUtil.createRandomNumber());
        }
    }
}
