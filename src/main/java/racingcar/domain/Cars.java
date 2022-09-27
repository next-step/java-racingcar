package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.view.ResultView;

import java.util.List;

public class CarRace {
    private List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public void print(ResultView resultView) {
        cars.forEach(resultView::print);
    }
}
