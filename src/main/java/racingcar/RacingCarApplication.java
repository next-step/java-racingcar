package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RandomStrategy;
import racingcar.exception.CarNameException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingCarApplication {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RandomStrategy randomStrategy = new RandomStrategy();
        Cars cars = new Cars(new ArrayList<>());

        try {
            cars.createCar(inputView.askNameOfCars());
        } catch (CarNameException e) {
            e.printStackTrace();
            return;
        }

        int tries = inputView.askNumberOfTries();
        for (int i = 0; i < tries; i++) {
            outputView.printResult(cars.startGame(randomStrategy));
        }
        outputView.printWinner(cars.findWinner());
    }
}
