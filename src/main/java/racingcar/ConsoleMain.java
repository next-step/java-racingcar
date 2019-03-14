package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.RacingGameOutputView;
import racingcar.view.RacingGameParameterInputView;
import racingcar.vo.RacingGameParameter;
import racingcar.vo.RacingResultOfRound;

public class ConsoleMain {
    public static void main(String[] args) {
        ConsoleMain.start();
    }

    public static void start() {
        RacingGameParameter parameter = RacingGameParameterInputView.readRacingGameParameter();
        RacingGame racingGame = new RacingGame(parameter);

        RacingResultOfRound racingResultOfFinalRound = runRacingGame(racingGame);

        RacingGameOutputView.printWinners(racingResultOfFinalRound);
    }

    public static RacingResultOfRound runRacingGame(RacingGame racingGame) {
        RacingResultOfRound racingResult = null;

        while (!racingGame.isEnd()) {
            racingResult = racingGame.race();
            RacingGameOutputView.printRacingResult(racingResult);
        }

        return racingResult;
    }
}