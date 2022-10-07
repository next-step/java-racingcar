package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.ui.ResultView;

public class Cars {

    private static final int DEFAULT_VALUE = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public void move(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.move(movableStrategy));
    }

    public void print(ResultView resultView) {
        cars.forEach(resultView::print);
        resultView.enter();
    }

    public String findWinners() {
        int maxPostion = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(DEFAULT_VALUE);

        return cars.stream()
            .filter(car -> car.equalsPosition(maxPostion))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

}
