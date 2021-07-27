package edu.nextstep.racingcar.step4;

import edu.nextstep.racingcar.step4.domain.CarStrategy;
import edu.nextstep.racingcar.step4.domain.Cars;
import edu.nextstep.racingcar.step4.view.InputView;
import edu.nextstep.racingcar.step4.view.ResultView;

public class App {

    private static final int NUMBER_OF_RANDOMS = 10;
    private static final int THRESHOLD = 4;
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String namesOfCars = inputView.getNamesOfCars();
        int numberOfAttempts = inputView.getNumberOfAttempts();

        Cars cars = Cars.make(namesOfCars, NUMBER_OF_RANDOMS, THRESHOLD);
        cars.play(numberOfAttempts, new CarStrategy());

        resultView.output(numberOfAttempts, cars);
        resultView.outputWinners(cars.getWinners());
    }
}
