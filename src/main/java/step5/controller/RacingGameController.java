package step5.controller;

import java.util.ArrayList;
import java.util.List;
import step5.domain.Car;
import step5.domain.RacingResult;
import step5.service.RacingGameService;
import step5.service.RacingWinner;
import step5.util.CarFactory;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingGameController {

    public RacingGameController() {
    }

    public static void start() {
        ResultView.printCarNames();
        String[] carNames = InputView.carNames();
        ResultView.printTryCount();
        int tryCount = InputView.tryCount();
        int carCount = carNames.length;
        ResultView.printStartMessage();

        List<Car> cars = CarFactory.createCar(carNames);

        List<RacingResult> racingResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingResults.addAll(RacingGameService.start(cars));
        }

        ResultView.printRacingResults(racingResults, carCount);

        String winner = RacingWinner.chooseWinner(cars);
        ResultView.printWinner(winner);
    }
}
