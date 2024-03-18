package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void start(InputValue input) {
        cars = Cars.makeCarList(input.getNameOfCars());

        ResultView.printResultMessage();
        for (int i = 0; i < input.getTryCount(); i++) {
            forward();
            System.out.println();
        }
        ResultView.printWinners(Record.getRecord(cars));

    }

    public void forward() {
        for (Car car : cars) {
            car.move(RandomUtil.randomCount(10));
        }
        ResultView.printResult(cars);
    }
}
