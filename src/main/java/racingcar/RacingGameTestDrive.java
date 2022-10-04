package racingcar;

import java.util.Scanner;

public class RacingGameTestDrive {
    public static void main(String[] args) {
        int carNumber, moveNumber;
        carNumber = RacingGameInputView.inputCarNumber();
        moveNumber = RacingGameInputView.inputMoveNumber();
        System.out.println("실행 결과");
        RacingGame.race(carNumber, moveNumber);
    }
}
