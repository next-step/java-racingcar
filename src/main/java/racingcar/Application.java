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
        List<Car> cars = new Cars(carNames).getCars();
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(cars, tryCount);
        System.out.println("실행 결과");
        racingCarGame.play();

        List<Car> MovingCars = racingCarGame.getMovingCars();
        List<String> winners = Referee.getWinners(MovingCars);
        ResultView.printGameResult(winners);
    }
}
