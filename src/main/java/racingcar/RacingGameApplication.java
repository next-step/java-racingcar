package racingcar;

import java.util.*;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames;
        int moveNumber;
        carNames = RacingGameInputView.inputCarNumber();
        moveNumber = RacingGameInputView.inputMoveNumber();
        RacingCarView.printMessage();
        List<Car> cars = RacingGame.race(carNames, moveNumber);
        RacingCarView.printRacingCar(cars);
        List<Car> winners = RacingGame.getWinners(cars);
        RacingCarView.printWinner(winners);
    }
}
