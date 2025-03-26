package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {
    public void showResults(List<Car> cars) {
        for (Car car : cars) {
            printCurrentPosition(car);
        }
        printEmptyLine();
    }

    public void printCurrentPosition(Car car) {
        System.out.println("-".repeat(car.getPosition()));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
