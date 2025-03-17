package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winnerCars) {
        String winnerCarNames = winnerCars.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
