package racingversion2;

import java.util.stream.IntStream;
import racingversion2.car.CarName;
import racingversion2.car.Cars;
import racingversion2.view.InputView;
import racingversion2.view.OutputView;

public class RacingGame {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        InputView inputView = new InputView();
        CarName[] carNames = inputView.settingCarNames();
        int turnCount = inputView.settingTryCount();
        Cars cars = new Cars(carNames);
        OutputView outputView = new OutputView();
        outputView.printResult();
        IntStream.range(0, turnCount).forEach(turn -> outputView.printCars(cars.executeTurn()));
        outputView.printWinners(cars.findWinners());
    }

}
