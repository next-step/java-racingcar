package racinggame;

import racinggame.model.Car;
import racinggame.model.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        String[] inputName = InputView.inputCarNames().split(",");
        int raceTime = InputView.inputRaceTime();

        RacingGame racingGame = new RacingGame(inputName, raceTime);

        while(!racingGame.isRaceEnd()) {
            List<Car> racingResult = racingGame.raceOneTime();
            ResultView.printResultRacing(racingResult);
        }

        List<String> racingGameWinnerList = racingGame.getWinner();
        ResultView.printRacingWinner(racingGameWinnerList);
    }
}
