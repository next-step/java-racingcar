package carRacing;

import java.util.List;

public class ResultView {

    public static void printResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.print(racingCar.getName() + " : ");
            printPosition(racingCar.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(Position position) {
        for (int i = 0; i < position.value(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }


}
