package racingcar;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(InputView.getCarNames(), InputView.getTryCount());

        racingCarGame.play();

        List<String> winners = Referee.getWinners(racingCarGame.getCars());
        ResultView.printGameResult(winners);
    }
}
