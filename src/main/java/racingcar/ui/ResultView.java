package racingcar.ui;

import racingcar.ui.dto.RacingGameResponse;

import java.util.HashMap;
import java.util.List;

public class ResultView {
    private final String CAR_STATUS_EXPRESSION = "-";

    public void showRacingCarGame(RacingGameResponse response) {
        HashMap<Integer, List<Integer>> moveCountsByTurn = response.getMoveCountsByTurn();
        for (int currentTurn = 1; currentTurn <= moveCountsByTurn.size(); currentTurn++) {
            System.out.println("Turn " + currentTurn);
            displayAllCarStatus(moveCountsByTurn.get(currentTurn));
        }
    }

    private void displayAllCarStatus(List<Integer> moveCounts) {
        for (int moveCount : moveCounts) {
            displayCarStatus(moveCount);
        }
    }

    private void displayCarStatus(int moveCount) {
        System.out.println(CAR_STATUS_EXPRESSION.repeat(moveCount));
    }
}
