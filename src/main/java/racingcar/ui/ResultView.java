package racingcar.ui;

import racingcar.application.RacingCarGameService;

import java.util.List;

public class ResultView {

    private final RacingCarGameService service;

    public ResultView(RacingCarGameService service) {
        this.service = service;
    }

    public void showRacingCarGame(int endTurn) {
        int currentTurn = 1;
        while (currentTurn <= endTurn) {
            System.out.println("Turn " + currentTurn);
            displayAllCarStatus();
            currentTurn += 1;
        }
    }

    private void displayAllCarStatus() {
        List<Integer> moveCounts = service.getAllCarMoveCount();
        for (int moveCount : moveCounts) {
            displayCarStatus(moveCount);
        }
    }

    private void displayCarStatus(int moveCount) {
        System.out.println("-".repeat(moveCount));
    }
}
