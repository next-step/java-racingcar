package racingCar;

import racingCar.domain.RacingCars;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView keyboardInput = InputView.getInputView();

        RacingCars cars = new RacingCars(keyboardInput.nameOfCars());
        int numberOfRounds = keyboardInput.numberOfRounds();

        RacingCars result = RacingGame.start(cars, numberOfRounds);

        ResultView.printResult(result);
    }
}