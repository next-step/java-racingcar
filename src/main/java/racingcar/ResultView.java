package racingcar;

import java.util.List;

public class ResultView {

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getState());
            System.out.println();
        }

        System.out.println();
    }
}
