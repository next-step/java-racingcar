package racingcar;

import racingcar.RacingCarGameLogic;
import racingcar.ui.InputView;

import java.util.*;

public class Racingcar {
    private static final int MAX_INPUT_VALUE = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCar = InputView.getInstance().inputNumberOfCar(scanner);
        int numberOfAttempt = InputView.getInstance().inputNumberOfAttempt(scanner);

        if(!isMaximumInput(numberOfCar, numberOfAttempt)) {
            RacingCarGameLogic.getInstance().gameLogic(numberOfCar, numberOfAttempt);
        }
    }

    public static boolean isMaximumInput(int numberOfCar, int numberOfAttempt) {
        if(numberOfCar > MAX_INPUT_VALUE && numberOfAttempt > MAX_INPUT_VALUE)
            return true;
        return false;
    }
}
