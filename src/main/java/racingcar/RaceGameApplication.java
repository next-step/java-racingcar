package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;

public class RaceGameApplication {

    public static void main(String[] args) {

        String carNames = InputView.readCarNames();
        int gameCount = InputView.readGameCount();
        RaceGame raceGame = new RaceGame(Arrays.stream(carNames.split(",")).toList(), gameCount);

        ResultView.printResultMessage();
        for (int i = 0; i < gameCount; i++) {
            raceGame.playRound();
            ResultView.printRoundResult(raceGame.cars());
        }
    }
}
