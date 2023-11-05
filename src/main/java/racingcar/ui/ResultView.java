package racingcar.ui;

import racingcar.ui.dto.RacingGameResponse;

public class ResultView {

    private final RacingGameController controller;

    public ResultView(RacingGameController controller) {
        this.controller = controller;
    }

    public void showRacingCarGame(int currentTurn, RacingGameResponse response) {
        System.out.println("Turn " + currentTurn);
        displayAllCarStatus(response);
    }

    private void displayAllCarStatus(RacingGameResponse response) {
        for (int moveCount : response.getMoveCounts()) {
            displayCarStatus(moveCount);
        }
    }

    private void displayCarStatus(int moveCount) {
        System.out.println("-".repeat(moveCount));
    }
}
