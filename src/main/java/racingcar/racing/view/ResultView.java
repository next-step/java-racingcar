package racingcar.racing.view;

import racingcar.racing.model.Car;

import java.util.List;

public class ResultView {
    public void view(List<Car> cars, int stage) {
        System.out.println("stage: " + stage);
        cars.forEach(car -> System.out.println("-".repeat(car.getPosition())));
        System.out.println();
    }
}
