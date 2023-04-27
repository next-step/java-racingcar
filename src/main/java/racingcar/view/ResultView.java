package racingcar.view;

import racingcar.model.Constant;
import racingcar.model.RoundScore;
import racingcar.model.RoundScores;

import java.util.List;
import java.util.Map;

import static racingcar.model.Constant.DASH;

public class ResultView {

    public void drawing(Map<Integer, RoundScores> roundResultMap) {
        for (RoundScores roundScores : roundResultMap.values()) {
            drawDash(roundScores);
            System.out.println();
        }
        System.out.println();
    }

    public void winner(List<String> winners) {
        String winner = String.join(Constant.DELIMITER, winners);
        System.out.println(winner + " 가 최종 우승했습니다.");
    }

    public void startUI() {
        System.out.println("실행결과");
    }

    private void drawDash(RoundScores roundScores) {
        for (RoundScore roundScore : roundScores.getScores()) {
            System.out.print(roundScore.getName() + ": ");
            System.out.print(DASH.repeat(roundScore.getScore() + 1));
            System.out.println();
        }
    }
}
