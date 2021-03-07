package racingcar.domain;

import racingcar.util.ResultView;

import java.util.LinkedList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(int numberOfCars) {
        cars = new LinkedList<>();
        for (int i = 0 ; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public void showResult() {
        cars.stream()
                .map(Car::showStatus)
                .forEach(ResultView::showResult);
        ResultView.printNewLine();
    }
}
