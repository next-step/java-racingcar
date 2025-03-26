package edu.nextstep.camp.carracing;

import edu.nextstep.camp.carracing.domain.Cars;
import edu.nextstep.camp.carracing.util.RandomNumberGenerator;
import edu.nextstep.camp.carracing.view.ResultView;

import java.util.List;

import static edu.nextstep.camp.carracing.view.InputView.getTryCount;
import static edu.nextstep.camp.carracing.view.InputView.inputCarNames;

public class CarRacingApplication {
    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int tryCount = getTryCount();

        Cars cars = Cars.fromNames(carNames);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(new RandomNumberGenerator(10));
            ResultView.printCarsStatus(cars);
        }
        ResultView.printWinners(cars.getWinners());
    }
}
