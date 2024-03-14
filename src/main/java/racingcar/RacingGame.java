package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void start(InputValue input) {
        for (int i = 0; i < input.getNumberOfCars(); i++) {
            cars.add(new Car());
        }
        ResultView.printResultMessage();
        for (int i = 0; i < input.getTryCount(); i++) {
            forward();
            System.out.println();
        }
    }

    public void forward() {
        for (Car car : cars) {
            car.move(RandomUtil.randomCount(10));
        }
        ResultView.printResult(cars);
    }
}
