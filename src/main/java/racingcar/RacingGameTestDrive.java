package racingcar;

import java.util.Scanner;

public class RacingGameTestDrive {
    public static void main(String[] args) {
        int carNumber, moveNumber;
        carNumber = RacingGameInputView.inputCarNumber();
        moveNumber = RacingGameInputView.inputMoveNumber();
        RacingCarView.printMessage();
        RacingGame.race(carNumber, moveNumber);
    }
}
