package racingcar.control;

import racingcar.model.Car;
import racingcar.view.FirstResultView;
import racingcar.view.ResultView;
import racingcar.view.View;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceControl {

    private final List<Car> cars;
    private final int maxTrials;
    private int trials = 0;

    public RaceControl(int cars, int trials) {
        if (cars < 0 || trials < 0) {
            throw new IllegalArgumentException("input must be not negative: " + cars + ", " + trials);
        }

        this.maxTrials = trials;
        this.cars = Stream
                .generate(Car::new)
                .limit(cars)
                .collect(Collectors.toList());
    }

    public void start() {
        while (trials < maxTrials) {
            this.cars.forEach(Car::move);
            this.view().render();
            this.trials++;
        }
    }

    private View view() {
        return trials == 0 ? new FirstResultView(cars) : new ResultView(cars);
    }
}
