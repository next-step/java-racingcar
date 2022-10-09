package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);
        ResultView.printResultStartMessage();
        while (!racingCarGame.isEnd()) {
            ResultView.printRoundResult(racingCarGame.playOneRound());
        }
        ResultView.printWinnerMessage(racingCarGame.getWinnerName());
    }
}
