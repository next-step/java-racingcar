package homework.week1.racingcar;

import homework.week1.racingcar.domain.Game;
import homework.week1.racingcar.domain.GameResult;
import homework.week1.racingcar.view.GameInputView;
import homework.week1.racingcar.view.GameResultView;

public class RacingCarGameMain {
    public static void main(String[] args) {
        GameResultView resultView = GameResultView.newInstance();

        String carStrings = GameInputView.inputCarName();
        String numberOfRacing = GameInputView.inputNumberOfRacing();

        Game racingCarGame = new Game(carStrings, numberOfRacing);
        int tryNumberOfRacing = 0;
        GameResult result = null;
        while (!racingCarGame.isFinishRace(tryNumberOfRacing)) {
            ++tryNumberOfRacing;
            result = racingCarGame.tryRace();
            resultView.printRaceResultCars(result);
        }

        if (result != null) {
            resultView.printWinnerCars(result.getWinnerNames(result.getMaxPosition()));
        }
    }
}
