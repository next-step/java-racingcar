package carRacing;

import java.util.List;

public class ResultView {

    public static void printResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printPosition(racingCar);
        }
        System.out.println();
    }

    private static void printPosition(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        racingCar.getPosition().printPosition();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }


}
