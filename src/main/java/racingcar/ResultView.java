package racingcar;

import java.util.List;

public class ResultView {

    public void printEachCar(Car car) {
        for (int i = 0; i < car.getCountMove(); i++) {
            System.out.print("-");
        }
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            printEachCar(car);

            System.out.println();
        }

        System.out.println();
    }
}
