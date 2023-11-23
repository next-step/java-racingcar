package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {
    public static void printWinnerNames(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printRoundResult(Cars cars) {
        printAsterisk();
        for (Car car : cars.getCars()) {
            printPosition(car);
        }
    }

    public static void printAsterisk() {
        System.out.println("*******************************************");
    }

    public static void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition().getPosition(); j++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
