package racingcar;

import racingcar.view.RacingCarView;
import racingcar.view.RacingGameInputView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames = RacingGameInputView.inputCarNumber();
        int moveNumber = RacingGameInputView.inputMoveNumber();
        RacingCarView.printMessage();
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> cars = racingGame.race(moveNumber);
        RacingCarView.printRacingCar(cars);
        RacingCarView.printWinner(racingGame.getWinner());
    }
}
