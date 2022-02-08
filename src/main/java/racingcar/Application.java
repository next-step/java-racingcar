package racingcar;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Referee referee = new Referee();
        ResultView resultView = new ResultView();

        RacingCarGame racingCarGame = new RacingCarGame(InputView.getCarNames(), InputView.getTryCount());

        racingCarGame.play();

        String winners = referee.getWinners(racingCarGame.getCars());
        resultView.printGameResult(winners);
    }
}
