package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {
    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResults(List<Car> cars) {
        for (Car car : cars) {
            printCurrentPosition(car);
        }
        printEmptyLine();
    }

    public void printCurrentPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
