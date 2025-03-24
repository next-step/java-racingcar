package racingcar;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.utils.NumberUtils;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        List<String> carNames = StringUtils.splitByComma(InputView.getCarNames());
        Cars cars = CarManager.initCars(carNames);

        int tryCount = NumberUtils.toInt(InputView.getTryCount());

        ResultView.printInitialState();
        ResultView.printHyphens(cars.getPositions());

        CarManager.move(cars, tryCount);
    }
}
