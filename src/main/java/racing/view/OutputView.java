package racing.view;

import racing.model.RacingCar;

import java.util.List;

public class OutputView {
    private final static String ICON = "-";

    public OutputView() {
    }

    public void showWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public void showRaceProgress(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + ICON.repeat(car.getMoveCondition()));
        }
        System.out.println();
    }
}
