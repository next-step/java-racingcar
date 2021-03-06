package racingcar;

import racingcar.util.InputView;

public class RacingMachine {
    private static String numberOfCars;
    private static String numberOfRounds;

    public static void main(String[] args) {
        numberOfCars = InputView.getNumberOfCar();
        numberOfRounds = InputView.getNumberOfRound();
    }
}
