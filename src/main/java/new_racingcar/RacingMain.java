package new_racingcar;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int playerCount = inputView.setPlayer();
        int turnCount = inputView.setTurn();

        GrandPrix grandPrix = new GrandPrix(playerCount, turnCount);
        List<Round> rounds = grandPrix.start();

        ResultView resultView = new ResultView();
        resultView.printGrandPrixRecords(rounds);
    }
}
