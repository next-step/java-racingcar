package refactoring.racingcar.view;

import refactoring.racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    public static void printPositions(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.print(racingCar.getName().getValue() + " : ");
            for (int i = 0; i < racingCar.getPosition().getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0).getName().getValue());
        for (int i = 1; i < winners.size(); i++) {
            sb.append(",");
            sb.append(winners.get(i).getName().getValue());
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
