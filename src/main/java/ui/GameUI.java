package ui;

import model.Car;

import java.util.List;

public class GameUI {
    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(String carName, int position) {
        System.out.printf("%s : %s%n", carName, "-".repeat(position));
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf("%s(이)가 최종 우승했습니다.", String.join(", ", winnerNames));
    }
}
