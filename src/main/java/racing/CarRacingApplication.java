package racing;

import racing.view.InputView;
import racing.view.OutputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        int numberOfCar = InputView.inputCarCount();
        Cars cars = new Cars(numberOfCar);
        RacingGame racingGame = new RacingGame(InputView.inputTryCount(), cars);
        OutputView.basicOutput();
        racingGame.startGame(new RandomMove());
    }

}
