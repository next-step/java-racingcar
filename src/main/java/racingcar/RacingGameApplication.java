package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameJudge;
import racingcar.view.RacingGameOutputView;
import racingcar.view.RacingGameParameterInputView;
import racingcar.vo.RacingGameParameter;
import racingcar.vo.RacingResultOfRound;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameApplication.start();
    }

    public static void start() {
        RacingGameParameter parameter = RacingGameParameterInputView.readRacingGameParameter();

        RacingGame racingGame = new RacingGame(parameter);
        RacingGameJudge racingGameJudge = new RacingGameJudge();

        RacingResultOfRound racingResultOfFinalRound = runRacingGame(racingGame);
        List<Car> winners = racingGameJudge.getWinners(racingResultOfFinalRound);

        RacingGameOutputView.printWinners(winners);
    }

    public static RacingResultOfRound runRacingGame(RacingGame racingGame) {
        RacingResultOfRound racingResult = null;

        while (!racingGame.isEnd()) {
            racingResult = racingGame.race();

            RacingGameOutputView.printRacingResult(racingResult);
            RacingGameOutputView.printEmptyLine();
        }

        return racingResult;
    }
}