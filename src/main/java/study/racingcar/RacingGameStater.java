package study.racingcar;

import study.racingcar.condition.RacingGameCondition;
import study.racingcar.input.ConsoleInputView;
import study.racingcar.input.InputView;
import study.racingcar.output.ConsoleGameStatusResultView;
import study.racingcar.output.ResultView;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGameStater {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        RacingGameCondition gameCondition = inputView.questionAndAnswer();

        ResultView resultView = new ConsoleGameStatusResultView();

        RacingGame racingGame = new RacingGame(
                gameCondition.getCountOfRacingCar(),
                gameCondition.getMoveCarTryLimit(),
                resultView);

        racingGame.start();
    }
}
