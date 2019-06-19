package study.racingcar;

import study.racingcar.input.ConsoleInputView;
import study.racingcar.input.InputView;
import study.racingcar.model.Awards;
import study.racingcar.model.Cars;
import study.racingcar.model.CarsRacingLog;
import study.racingcar.model.RacingGameInfo;
import study.racingcar.output.ConsoleGameStatusResultView;
import study.racingcar.output.ResultView;
import study.racingcar.strategy.MaxPositionWinnerStrategy;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGameStater {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        RacingGameInfo racingGameInfo = inputView.questionAndAnswer();

        RacingGame racingGame = new RacingGame(
                racingGameInfo.getCarNames(),
                racingGameInfo.getMoveCarTryLimit()
        );

        List<CarsRacingLog> carsRacingLogs = racingGame.start();

        Awards awards = new Awards(new MaxPositionWinnerStrategy());
        CarsRacingLog lastCarsRacingLog = carsRacingLogs.get(carsRacingLogs.size() - 1);
        Cars winners = awards.award(lastCarsRacingLog);

        ResultView resultView = new ConsoleGameStatusResultView();
        resultView.printInit();
        resultView.printRacingLogs(carsRacingLogs);
        resultView.printWinners(winners);
    }
}
