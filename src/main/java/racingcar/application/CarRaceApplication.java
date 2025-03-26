package racingcar.application;

import racingcar.domain.CarRace;
import racingcar.domain.CarState;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class CarRaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int runCount = inputView.getRunCount();

        CarRace carRace = createGame(carNames, runCount);
        List<List<CarState>> results = carRace.run();
        List<CarState> winners = carRace.findWinners();

        ResultView resultView = new ResultView();
        resultView.print(results);
        resultView.printWinners(winners);
    }

    private static CarRace createGame(List<String> carNames, int runCount) {
        Cars cars = Cars.from(carNames);
        MoveStrategy moveStrategy = new MoveStrategy(new RandomNumberGenerator());

        return new CarRace(cars, runCount, moveStrategy);
    }

}
