package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingController {

    public void run() {
        String[] names = InputView.getCarNames();
        int roundNum = InputView.getRoundNumber();

        Cars cars = Cars.from(names);

        Random random = new Random();
        Racing racing = new Racing(cars.getCars(), random);

        for (int i = 0; i < roundNum; i++) {
            ResultView.roundStart(i + 1);
            List<RacingResult> carPositions = racing.play();
            ResultView.drawCarPositions(carPositions);
        }
        List<Car> winners = cars.findWinners();
        ResultView.printWinners(winners);
    }
}
