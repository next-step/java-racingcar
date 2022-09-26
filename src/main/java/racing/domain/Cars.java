package racing.domain;

import java.util.List;
import racing.ui.ResultView;

public class Cars {

    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.move(movableStrategy.randomMovable()));
    }

    public void print(ResultView resultView) {
        cars.forEach(resultView::print);
    }

}
