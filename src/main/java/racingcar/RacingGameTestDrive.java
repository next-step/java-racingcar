package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingGameTestDrive {
    public static void main(String[] args) {
        String carNames;
        int moveNumber;
        carNames = RacingGameInputView.inputCarNumber();
        moveNumber = RacingGameInputView.inputMoveNumber();
        RacingCarView.printMessage();
        List<Car> cars = RacingGame.race(carNames, moveNumber);
        RacingCarView.printRacingCar(cars);
    }
}
