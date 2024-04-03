package racing;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.domain.TryCount;

import java.util.List;

import static racing.domain.Car.findWinners;
import static racing.domain.Cars.createCarsFromNames;
import static racing.view.InputView.inputCarNames;
import static racing.view.InputView.inputTryCount;
import static racing.view.ResultView.*;

public class  RacingMain {
    public static void main(String[] args) {
        String[] names = inputCarNames().split(",");
        List<Car> cars = createCarsFromNames(names);
        TryCount tryCount = new TryCount(inputTryCount());
        RacingGame game = new RacingGame(tryCount.getTryCount(), cars);

        printResultMessage();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            game.carMove(cars);
            printResult(cars);
        }
        printWinners(findWinners(cars));
    }
}
