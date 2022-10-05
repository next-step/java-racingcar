package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.ui.ResultView;

public class Cars {

    List<Car> cars;

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
        int max = cars.stream().mapToInt(Car::getDistance).max().getAsInt();

        return cars.stream()
            .filter(car -> car.getDistance() == max)
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

}
