package racingcar.Application;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.domain.RandomCreator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputRound());
        RacingGameResult racingGameResult = new RacingGameResult();

        ResultView.println("경기 시작!!!");
        while(!racingGame.isFinished()) {
            ResultView.printRoundResult(racingGame.playRound(new RandomCreator()));
        }

        ResultView.announceWinner(racingGameResult.collectWinners(racingGame.sortCars()));
    }
}
