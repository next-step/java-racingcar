package carRacingGame;

import java.util.Map;

public class PrintView {

    public static void printCars(Map<String, String> cars) {
        cars.forEach((carName, position) -> {
            System.out.println(carName + " : " + position);
        });
    }

    public static void printWinners(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");

    }
}
