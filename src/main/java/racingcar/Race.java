package racingcar;

import racingcar.rule.Rule;
import racingcar.util.NumberGenerator;

import java.util.List;

public class Race {

    private Rule rule;

    private NumberGenerator numberGenerator;

    private List<Car> cars;

    public Race(List<Car> cars, Rule rule, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.rule = rule;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if(movable()) {
            car.move();
        }
    }
    private boolean movable() {
        return rule.verify(numberGenerator.get());
    }
}
