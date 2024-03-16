package racingcar;

import racingcar.ui.InputView;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String nameOfCars = inputView.inputNamesOfCar();
        int numberOfAttempt = inputView.inputNumberOfAttempt();

        RacingCarGameService.getInstance().gameLogic(nameOfCars, numberOfAttempt);
    }

}
