package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);

        racingCarGame.play();

        List<Car> cars = racingCarGame.getCars();
        List<String> winners = Referee.getWinners(cars);
        ResultView.printGameResult(winners);
    }
}
