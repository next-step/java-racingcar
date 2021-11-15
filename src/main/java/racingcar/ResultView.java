package racingcar;

import java.util.List;

public class ResultView {

    public void printResult(final List<Car> cars) {
        cars.forEach(Car::printCurrentPosition);
        System.out.println();
    }
}
