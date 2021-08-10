package racingcargame.view;

<<<<<<< HEAD
import racingcargame.model.RacingCar;

import java.util.List;

public class RacingCarGameOutputView {
    private static final String STEP = "-";

    public void outputRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + stackUpSteps(car.getStep()));
        }
        System.out.println();
    }

    private String stackUpSteps(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append(STEP);
=======
import racingcargame.model.History;
import racingcargame.model.RacingCar;

import java.util.List;
import java.util.Map;

public class RacingCarGameOutputView {
    private static final String BAR = "-";

    public void outputGame(List<History> histories) {
        System.out.println("\n실행 결과");
        for (History history : histories) {
            outputRound(history.getHistory());
            System.out.println();
        }
    }

    private void outputRound(Map<RacingCar, Integer> history) {
        for (Map.Entry<RacingCar, Integer> entry : history.entrySet()) {
            System.out.println(entry.getKey() + " : " + stackUpBars(entry.getValue()));
        }
    }

    private String stackUpBars(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append(BAR);
>>>>>>> origin/step2
        }
        return bar.toString();
    }

<<<<<<< HEAD
    public void outputWinners(String winners) {
        System.out.println("최종 우승자:" + winners);
=======
    public void outputWinners(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
>>>>>>> origin/step2
    }
}
