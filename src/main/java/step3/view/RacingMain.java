package step3.view;

import step3.application.domain.RaceGame;
import step3.application.domain.model.dto.RaceGameLog;
import step3.application.generator.MovableRandomGenerator;

import java.util.Arrays;
import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputText = inputView.receiveDriver();
        int moveCount = inputView.receiveMoveCount();

        List<String> names = splitTextAsNames(inputText);

        RaceGame raceGame = new RaceGame(names);
        RaceGameLog raceGameLog = raceGame.startRace(moveCount,new MovableRandomGenerator());
        int maxPosition = raceGame.extractMaxPosition();
        List<String> bestDrivers = raceGame.findBest(maxPosition, names);

        ResultView resultView = new ResultView();
        resultView.printRacingHistory(raceGameLog);
        resultView.printBestDriver(bestDrivers);
    }

    private static List<String> splitTextAsNames(String inputText) {
        return Arrays.asList(inputText.split(","));
    }
}
