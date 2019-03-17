package racingcar.Application;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputRound());
        RacingGameResult racingGameResult = new RacingGameResult();

        ResultView.println("경기 시작!!!");
        for(int round = 0; round < racingGame.getTime(); round++) {
            ResultView.printRoundResult(racingGame.playRound());
        }
        
        ResultView.announceWinner(racingGameResult.collectWinners(racingGame.sortCars()));
    }
}
