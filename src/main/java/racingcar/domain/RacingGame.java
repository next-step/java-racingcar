package racingcar.domain;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars;

    public RacingGame(int time, int number) {
        this.time = time;
        this.cars = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public void start() {
        ResultView.printResult();

        for (int i = 0; i < time; i++) {
            cars.forEach(car -> ResultView.printPosition(car.move()));

            ResultView.printNewLine();
        }
    }
}
