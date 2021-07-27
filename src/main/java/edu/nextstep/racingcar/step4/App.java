package edu.nextstep.racingcar.step4;

import edu.nextstep.racingcar.step4.domain.Cars;
import edu.nextstep.racingcar.step4.domain.DefaultMoveStrategy;
import edu.nextstep.racingcar.step4.view.InputView;
import edu.nextstep.racingcar.step4.view.ResultView;

public class App {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String namesOfCars = inputView.getNamesOfCars();
        int numberOfAttempts = inputView.getNumberOfAttempts();

        Cars cars = Cars.create(namesOfCars);
        cars.play(numberOfAttempts, new DefaultMoveStrategy());

        resultView.output(numberOfAttempts, cars);
        resultView.outputWinners(cars.getWinners());
    }
}
