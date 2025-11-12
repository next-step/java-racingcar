package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameApplication {

    private static final String CAR_NAME_DELIMITER = ",";

    public static void main(String[] args) {

        String carNames = InputView.readCarNames();
        int gameCount = InputView.readGameCount();
        RaceGame raceGame = new RaceGame(parseCarNames(carNames), gameCount);

        ResultView.printResultMessage();
        for (int i = 0; i < gameCount; i++) {
            raceGame.playRound();
            ResultView.printRoundResult(raceGame.cars());
        }

        ResultView.printWinners(raceGame.getWinners());
    }

    private static List<String> parseCarNames(String input) {
        String[] names = input.split(CAR_NAME_DELIMITER);
        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(name.trim());
        }
        return carNames;
    }
}
