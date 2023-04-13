package racingcar;

import java.util.List;

public class OutputView {

    public static void printPosition(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(getPrintData(racingCar));
        }
        System.out.println();
    }

    private static String getPrintData(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getName());
        sb.append(" : ");
        for (int i = 0; i < racingCar.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(List<RacingCar> winners) {
        for (RacingCar winner : winners) {
            System.out.print(winner.getName());
            if (winners.indexOf(winner) != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
