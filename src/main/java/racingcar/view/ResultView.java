package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printWinners(List<Car> winners) {
        System.out.println(winners.stream().map(car -> car.getName().getName()).collect(Collectors.joining(",")) + "가 최종 우승했습니다.");
    }

    public static void printResult(List<List<Car>> results) {
        for (List<Car> roundResult : results) {
            System.out.println("*******************************************");
            printRound(roundResult);
        }
    }

    private static void printRound(List<Car> roundResult) {
        for (Car car : roundResult) {
            printPosition(car);
        }
    }

    private static void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition().getPosition(); j++) {
            System.out.print('-');
        }
        System.out.println();
    }
}