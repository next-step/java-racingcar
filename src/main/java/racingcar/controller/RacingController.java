package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    public void run() {
        String[] names = InputView.getCarNames();
        int roundNum = InputView.getRoundNumber();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carList.add(new Car(names[i]));
        }

        Cars cars = new Cars(carList);
        Racing racing = new Racing(cars.getCars());

        for (int i = 0; i < roundNum; i++) {
            ResultView.roundStart(i + 1);
            List<RacingResult> carPositions = racing.play();
            ResultView.drawCarPositions(carPositions);
        }
        List<Car> winners = cars.findWinners();
        ResultView.printWinners(winners);
    }
}
