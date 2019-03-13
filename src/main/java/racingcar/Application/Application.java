package racingcar.Application;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();


        RacingGame racingGame = new RacingGame(inputView.inputCarNames(), inputView.inputRound());
        resultView.println("경기 시작!!!");
        for(int round = 0; round < racingGame.getTime(); round++) {
            resultView.printRoundResult(racingGame.playRound());
        }

        resultView.announceWinner(racingGame.sortWinners());
    }
}
