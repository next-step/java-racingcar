package step4.view;

import step4.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            printLine(car);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = getWinnerNames(winners);
        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }

    private static void printLine(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private static String getWinnerNames(List<Car> winners) {
        return winners
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
