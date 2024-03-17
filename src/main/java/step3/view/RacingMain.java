package step3.view;

import step3.application.domain.RaceGame;
import step3.application.domain.model.RacingHistory;

import java.util.Arrays;
import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputText = inputView.receiveDriver();
        int moveCount = inputView.receiveMoveCount();

        List<String> names = splitTextAsNames(inputText);

        RaceGame raceGame = new RaceGame(names);
        RacingHistory racingHistory = raceGame.startRace(moveCount);

        ResultView resultView = new ResultView();
        resultView.printRacingHistory(racingHistory);
    }

    private static List<String> splitTextAsNames(String inputText) {
        return Arrays.asList(inputText.split(","));
    }
}
