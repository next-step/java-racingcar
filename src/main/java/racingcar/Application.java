package racingcar;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Referee referee = new Referee();
        ResultView resultView = new ResultView();

        int tryCount = inputView.getTryCount();
        List<String> carNames = inputView.getCarNames();
        RacingCarGame racingCarGame = new RacingCarGame(tryCount, carNames);

        racingCarGame.play();

        String winners = referee.getWinners(racingCarGame.getCars());
        resultView.printGameResult(winners);
    }
}
