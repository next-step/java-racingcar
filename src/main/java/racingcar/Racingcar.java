package racingcar;

import racingcar.ui.InputView;

import java.util.*;

public class Racingcar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfCars = InputView.getInstance().inputNamesOfCar(scanner);
        int numberOfAttempt = InputView.getInstance().inputNumberOfAttempt(scanner);

        RacingCarGameLogic.getInstance().gameLogic(nameOfCars, numberOfAttempt);
    }

}
