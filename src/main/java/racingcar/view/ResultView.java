package racingcar.view;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

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

    public void printWinners(List<Car> cars) {
        String winnerNames = cars.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printCurrentPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
