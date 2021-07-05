package racingcargame.view;

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
        }
        return bar.toString();
    }

    public void outputWinners(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
