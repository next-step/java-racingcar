package racing.view;

import racing.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private final static String ICON = "-";

    public static void showWinners(List<RacingCar> cars) {
        List<String> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            winners.add(car.getName());
        }
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void showRaceProgress(RacingCar car) {
        System.out.println(car.getName() + " : " + ICON.repeat(car.getProgress()));
    }
}
