package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.PositiveNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final Cars cars = mapToCars(InputView.getCarNames());
        final PositiveNumber tryNo = mapToPositiveNumber(InputView.getTryNo());

        final Game game = new Game(cars, tryNo);
        OutputView.printDivider();
        OutputView.printGameResultTitle();
        while (!game.isGameOver()) {
            game.play();
            OutputView.printCarStatuses(game.getCarStatuses());
            OutputView.printDivider();
        }
        OutputView.printWinners(game.getWinnerCarNames());
    }

    private static PositiveNumber mapToPositiveNumber(final String tryNo) {
        return new PositiveNumber(tryNo);
    }

    private static Cars mapToCars(final String[] carNames) {
        return new Cars(mapToCarList(carNames));
    }

    private static List<Car> mapToCarList(final String[] carNames) {
        return Arrays.stream(carNames)
            .map(String::trim)
            .map(CarName::from)
            .map(CarFactory::getDefaultCar)
            .collect(Collectors.toUnmodifiableList());
    }
}
