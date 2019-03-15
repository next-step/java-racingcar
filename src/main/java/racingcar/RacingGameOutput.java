package racingcar;

import java.util.List;

public class RacingGameOutput {

    public static void showRaceOf(List<RacingCar> racingCars) {
        racingCars.forEach(RacingCar::printPosition);
        System.out.println();
    }

    public static void showFinalWinner(List<RacingCar> winners) {
        for (int i = 0; i < winners.size(); i++) {
            winners.get(i).printName();

            if (i + 1 < winners.size()) {
                System.out.print(", ");
            }
        }
        System.out.print("가 최종 우승했습니다.");
    }
}
