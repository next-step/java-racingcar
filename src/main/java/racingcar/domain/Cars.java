package racingcar.domain;

import racingcar.util.ResultView;

import java.util.LinkedList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames) {
        cars = new LinkedList<>();
        for (String carName : carNames) {
            cars.add(new Car(new RandomEngine(), carName));
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public void showResult() {
        cars.forEach(ResultView::showResult);
        ResultView.printNewLine();
    }
}
