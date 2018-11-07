package racinggame;

import racinggame.model.Car;
import racinggame.model.RacingGame;
import racinggame.model.RacingGameResult;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {

        String[] inputName = InputView.inputCarNames().split(",");
        int raceTime = InputView.inputRaceTime();

        RacingGame racingGame = new RacingGame(inputName, raceTime);

        List<Car> racingResult = null;
        while(!racingGame.isRaceEnd()) {
            racingResult = racingGame.raceOneTime();
            ResultView.printResultRacing(racingResult);
        }

        RacingGameResult racingGameResult = new RacingGameResult(racingResult);

        List<String> racingGameWinnerList = racingGameResult.getWinner();
        ResultView.printRacingWinner(racingGameWinnerList);
    }
}
