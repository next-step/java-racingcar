package racingGame.view;

import racingGame.domain.Car;

import java.util.List;

public class OutputView {

    public static void printRace(List<Car> cars, int time) {
        for (int i = 0; i < time; i++) {
            printPosition(cars, i);
        }
        System.out.println();
    }

    private static void printPosition(List<Car> cars, int time) {
        System.out.println();
        for (Car car : cars) {
            System.out.print(car.getName() + "\t: ");
            int carPosition = car.getPosition(time);
            System.out.println("-".repeat(carPosition));
        }
    }

    public static void printWinners(String winnerNames) {
        System.out.print(winnerNames);
        System.out.print("(이)가 최종 우승했습니다.");
    }
}
