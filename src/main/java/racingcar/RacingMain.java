package racingcar;

import java.util.List;

import racingcar.service.Racing;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(new Racing());
        List<String> input = inputView.inputRacingByName();

        List<String> result = racingGame.setInRacingByName(input);
        ResultView resultView = new ResultView();
        resultView.racingResult(result);
    }

}