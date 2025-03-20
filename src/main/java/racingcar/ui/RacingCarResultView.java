package racingcar.ui;

import java.util.List;

import racingcar.RacingCar;
import utils.RandomUtils;

public class RacingCarResultView {

    public static void view(List<RacingCar> racingCars) {
        RacingCarResultView.display(racingCars);
        System.out.println();
    }

    public static void display(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            System.out.println(car.display());
        }
    }

    public static void winnersView(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size() - 1; i++) {
            RacingCar winner = winners.get(i);
            sb.append(winner.getCarName());
            sb.append(", ");
        }

        sb.append(winners.get(winners.size() - 1).getCarName());
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }
}
