package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameResultView;
import racingcar.view.RacingGameInputView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames = RacingGameInputView.inputCarNumber();
        int moveNumber = RacingGameInputView.inputMoveNumber();
        RacingGameResultView.printMessage();
        RacingGame racingGame = new RacingGame(carNames);
        List<Car> cars = racingGame.race(moveNumber);
        RacingGameResultView.printRacingCar(cars);
        RacingGameResultView.printWinner(racingGame.getWinner());
    }
}
