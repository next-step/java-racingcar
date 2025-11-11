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
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(RacingGame racingGame) {
        System.out.println(String.join(", ", racingGame.selectWinner()) + "가 최종 우승했습니다.");
    }


}
