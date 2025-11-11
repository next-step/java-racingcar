package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceGameApplication {

    public static void main(String[] args) {

        int carCount = InputView.readCarCount();
        int gameCount = InputView.readGameCount();
        RaceGame raceGame = new RaceGame(carCount, gameCount);
        
        ResultView.printResultMessage();
        for (int i = 0; i < gameCount; i++) {
            raceGame.playRound();
            ResultView.printRoundResult(raceGame.cars());
        }
    }
}
