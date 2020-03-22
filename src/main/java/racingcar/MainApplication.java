package racingcar;

import racingcar.controller.RacingCar;
import racingcar.model.Cars;
import racingcar.model.Results;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainApplication {
    public static void main(String[] args) {
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        String carNames = InputView.getCarNamesFromUser();
        String tryCounts = InputView.getTryCountsFromUser();
        InputView inputView = new InputView(carNames, tryCounts);

        RacingCar racingCar = new RacingCar(inputView);
        Cars cars = racingCar.ready();
        Results results = racingCar.start(randomNumGenerator);
        Winners winners = racingCar.findWinners();

        OutputView.printGame(cars, results);
        OutputView.printWinners(winners);
    }
}