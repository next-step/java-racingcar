package step5;

import java.util.ArrayList;
import java.util.List;
import step5.controller.RacingGameController;
import step5.domain.Car;
import step5.util.CarFactory;
import step5.service.RacingGameService;
import step5.domain.RacingResult;
import step5.service.RacingWinner;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarApplication.run();
    }

    public static void run(){
        RacingGameController.start();
        ResultView.printCarNames();
        String[] carNames = InputView.carNames();
        int carCount = carNames.length;
        ResultView.printTryCount();
        int tryCount = InputView.tryCount();

        List<Car> cars = CarFactory.createCar(carNames);

        ResultView.printStartMessage();

        List<RacingResult> racingResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingResults.addAll(RacingGameService.start(cars));
        }

        ResultView.printRacingResults(racingResults, carCount);

        String winner = RacingWinner.chooseWinner(cars);
        ResultView.printWinner(winner);
    }
}
