package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        Cars cars = new Cars(carNames);
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(cars, tryCount);

        ResultView.printGameResultMessage();

        racingCarGame.play();
        ResultView.printGameStatus(cars);

        //List<Car> movingCars = racingCarGame.getMovingCars();
        List<String> winners = Referee.getWinners(cars);
        ResultView.printGameResult(winners);
    }
}
